package com.example.santanderweek.data

data class Conta(
    val numero: String,
    val limite: String,
    val saldo: String,
    val agencia: String,
    val cliente: Cliente,
    val cartao: Cartao
)