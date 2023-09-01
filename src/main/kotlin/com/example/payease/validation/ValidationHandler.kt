package com.example.payease.validation

import com.example.payease.model.Users
import java.math.BigDecimal

interface ValidationHandler {
    fun validate(user: Users, amount: BigDecimal): Boolean
    fun setNextHandler(handler: ValidationHandler)
}