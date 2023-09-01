package com.example.payease.controller

import com.example.payease.dto.CreateTransactionDto
import com.example.payease.model.Transactions
import com.example.payease.service.TransactionsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/transaction")
class TransactionsController(private val transactionsService: TransactionsService) {

    @PostMapping()
    fun transaction(@RequestBody createTransactionDto: CreateTransactionDto): Transactions {
        return this.transactionsService.createTransaction(createTransactionDto)
    }
}