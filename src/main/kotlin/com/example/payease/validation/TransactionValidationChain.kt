package com.example.payease.validation

import com.example.payease.model.UserType
import com.example.payease.model.Users
import java.math.BigDecimal

class ZeroAmountHandler : ValidationHandler {
    private var nextHandler: ValidationHandler? = null

    override fun setNextHandler(handler: ValidationHandler) {
        nextHandler = handler
    }

    override fun validate(user: Users, amount: BigDecimal): Boolean {
        if (amount <= BigDecimal.ZERO) {
            return false
        }
        return nextHandler?.validate(user, amount) ?: true
    }
}

class BalanceHandler : ValidationHandler {
    private var nextHandler: ValidationHandler? = null

    private fun userHasBalance(user: Users, amountToTransfer: BigDecimal): Boolean {
        val userWallet = user.wallet
        return userWallet.balance >= amountToTransfer
    }

    override fun setNextHandler(handler: ValidationHandler) {
        nextHandler = handler
    }

    override fun validate(user: Users, amount: BigDecimal): Boolean {
        if (!userHasBalance(user, amount)) {
            return false
        }
        return nextHandler?.validate(user, amount) ?: true
    }
}

class ShopkeeperHandler : ValidationHandler {
    private var nextHandler: ValidationHandler? = null

    override fun setNextHandler(handler: ValidationHandler) {
        nextHandler = handler
    }

    override fun validate(user: Users, amount: BigDecimal): Boolean {
        if (user.type == UserType.SHOPKEEPER) {
            return false
        }
        return nextHandler?.validate(user, amount) ?: true
    }
}

/*
class AuthorizationHandler : ValidationHandler {
    override fun setNextHandler(handler: ValidationHandler) {
        // This is the last handler in the chain, so no need to set next handler.
    }

    override fun validate(user: Users, amount: BigDecimal): Boolean {
        return isAuthorized(user)
    }
}*/