package com.example.payease.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "id", nullable = false, updatable = false)
        var id: UUID? = null,

        @Column(name = "created_date", nullable = false, updatable = false)
        var createdDate: LocalDateTime = LocalDateTime.now()
)