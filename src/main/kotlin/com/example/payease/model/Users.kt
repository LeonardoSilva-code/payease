package com.example.payease.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class Users(
    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "cpf_cnpj", nullable = false, unique = true)
    var cpfCnpj: String,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: UserType,

   @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
   val wallet: Wallet
): BaseEntity()

enum class UserType(type: String){
    COMMON("Common"),
    SHOPKEEPER("Shopkeeper")
}