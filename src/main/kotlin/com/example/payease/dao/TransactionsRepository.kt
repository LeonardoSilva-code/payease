package com.example.payease.dao

import com.example.payease.model.Transactions
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TransactionsRepository: JpaRepository<Transactions, UUID> {
}