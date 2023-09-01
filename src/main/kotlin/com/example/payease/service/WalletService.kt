package com.example.payease.service

import com.example.payease.dao.WalletRepository
import com.example.payease.model.Wallet
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class WalletService(private val walletRepository: WalletRepository) {

    fun createWallet(wallet: Wallet): Wallet {
        return this.walletRepository.save(wallet)
    }
}