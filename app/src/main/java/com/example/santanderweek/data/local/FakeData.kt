package com.example.santanderweek.data.local

import com.example.santanderweek.data.Cartao
import com.example.santanderweek.data.Cliente
import com.example.santanderweek.data.Conta

class FakeData {

    fun getLocalData(): Conta {
        val cliente = Cliente("Pedro da Silva")
        val cartao = Cartao("142356")
        return Conta(
            numero = "1234",
            limite = "1.000,00",
            saldo = "1.500,00",
            cartao = cartao,
            cliente = cliente,
            agencia = "2311"
        )
    }
}