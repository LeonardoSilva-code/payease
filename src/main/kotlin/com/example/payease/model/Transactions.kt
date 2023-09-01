package com.example.payease.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "transactions")
data class Transactions (
        @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
        @JoinColumn(name = "sender_id")
        val sender: Users,

        @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
        @JoinColumn(name = "receiver_id")
        val receiver: Users,

        @Column(name = "amount", nullable = false)
        val amount: BigDecimal,

        @Column(name = "status", nullable = false)
        @Enumerated(EnumType.STRING)
        var status: TransactionStatus,
) : BaseEntity()

enum class TransactionStatus(status: String){
    PENDING("Pending"),
    COMPLETED("Completed"),
    REFUSED("Refused")
}