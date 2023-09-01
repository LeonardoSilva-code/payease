package com.example.payease.dao

import com.example.payease.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<Users, UUID> {
}