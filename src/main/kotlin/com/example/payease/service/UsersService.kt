package com.example.payease.service

import com.example.payease.dao.UserRepository
import com.example.payease.dto.CreateUserDto
import com.example.payease.dto.toEntity
import com.example.payease.model.Users
import com.example.payease.model.Wallet
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.UUID

@Service
class UsersService(private val userRepository: UserRepository,
                   private val walletService: WalletService) {

    fun getAll(): MutableList<Users> {
        return this.userRepository.findAll()
    }

    fun getById(id: UUID): Users? {
        return this.userRepository.findByIdOrNull(id)
    }

    fun deleteById(id: UUID){
        return this.userRepository.deleteById(id);
    }

    fun createUser(createUserDto: CreateUserDto): Users {
        var newUserWallet = this.createEmptyWallet()
        return this.userRepository.save(createUserDto.toEntity(newUserWallet))
    }

    private fun createEmptyWallet(): Wallet {
        return Wallet(
                balance = BigDecimal(0)
                )
    }
}