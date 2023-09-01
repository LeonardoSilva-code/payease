package com.example.payease.dto

import com.example.payease.model.UserType
import com.example.payease.model.Users
import com.example.payease.model.Wallet
import java.math.BigDecimal

data class CreateUserDto(
        val name: String,
        val email: String,
        val cpfCnpj: String,
        val password: String,
        val type: UserType,
)

fun CreateUserDto.toEntity(wallet: Wallet) = Users(
        name = name,
        email = email,
        cpfCnpj = cpfCnpj,
        password = password,
        type = type,
        wallet = wallet
)