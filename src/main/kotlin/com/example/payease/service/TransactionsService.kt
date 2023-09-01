package com.example.payease.service

import com.example.payease.dao.TransactionsRepository
import com.example.payease.dto.CreateTransactionDto
import com.example.payease.model.TransactionStatus
import com.example.payease.model.Transactions
import com.example.payease.model.UserType
import com.example.payease.model.Users
import com.example.payease.validation.BalanceHandler
import com.example.payease.validation.ShopkeeperHandler
import com.example.payease.validation.ZeroAmountHandler
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class TransactionsService(private val transactionsRepository: TransactionsRepository,
                          private val usersService: UsersService) {

    fun createTransaction(createTransactionDto: CreateTransactionDto): Transactions {
        val senderUser = this.usersService.getById(createTransactionDto.senderId) ?: throw IllegalStateException("Can't find sender user with id=${createTransactionDto.senderId}");
        val receiverUser = this.usersService.getById(createTransactionDto.receiverId) ?: throw IllegalStateException("Can't find receiver user with id=${createTransactionDto.receiverId}");
        var userTransaction = this.registerTransaction(senderUser, receiverUser, createTransactionDto.amount);
        val isValid = this.validateTransferEligibility(senderUser, createTransactionDto.amount);
        if(!isValid){
            this.rollbackTransaction(userTransaction)
            throw IllegalStateException("Transaction refused");
        }
        return this.makeTransaction(senderUser, receiverUser, createTransactionDto.amount, userTransaction)
    }

    private fun validateTransferEligibility(user: Users, amountToTransfer: BigDecimal): Boolean {
        val zeroAmountHandler = ZeroAmountHandler()
        val balanceHandler = BalanceHandler()
        val shopkeeperHandler = ShopkeeperHandler()
        zeroAmountHandler.setNextHandler(balanceHandler)
        balanceHandler.setNextHandler(shopkeeperHandler)
        return zeroAmountHandler.validate(user, amountToTransfer)
    }

    private fun userHasBalance(user: Users, amountToTransfer: BigDecimal): Boolean {
        val userWallet = user.wallet
        return userWallet.balance >= amountToTransfer
    }

    private fun registerTransaction(sender: Users, receiver: Users, amount: BigDecimal): Transactions {
        val transaction = Transactions(
                sender = sender,
                receiver = receiver,
                amount = amount,
                status =  TransactionStatus.PENDING
        )
        return this.transactionsRepository.save(transaction)
    }

    private fun rollbackTransaction(transaction: Transactions){
        transaction.status = TransactionStatus.REFUSED
        this.transactionsRepository.save(transaction)
    }

    private fun makeTransaction(sender: Users, receiver: Users, amount: BigDecimal, userTransactions: Transactions): Transactions {
        var senderWallet = sender.wallet
        var receiverWallet = receiver.wallet
        senderWallet.balance -= amount
        receiverWallet.balance += amount
        userTransactions.status = TransactionStatus.COMPLETED
        return this.transactionsRepository.save(userTransactions)
    }
}