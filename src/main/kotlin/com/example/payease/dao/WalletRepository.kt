package com.example.payease.dao

import com.example.payease.model.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface WalletRepository: JpaRepository<Wallet, UUID> {
}