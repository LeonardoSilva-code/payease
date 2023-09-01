package com.example.payease.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "wallet")
data class Wallet(
    var balance: BigDecimal,
) : BaseEntity()