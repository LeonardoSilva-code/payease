package com.example.payease.dto

import java.math.BigDecimal
import java.util.*

data class CreateTransactionDto (
        val senderId: UUID,
        val receiverId: UUID,
        val amount: BigDecimal
)

