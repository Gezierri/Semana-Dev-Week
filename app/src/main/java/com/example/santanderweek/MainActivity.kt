package com.example.santanderweek

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderweek.data.Conta
import com.example.santanderweek.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()

    }

    private fun buscarContaCliente(){
        mViewModel.buscarConta().observe(this, Observer {
            bindOnResult(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_notification -> {
                Log.i("Item 1", "Item 1 clicado")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun bindOnResult(conta: Conta){
        text_view_agencia.text = conta.agencia
        text_view_conta.text = conta.numero
        text_view_saldo.text = conta.saldo
        text_view_saldo_limite.text = conta.limite
        text_view_agencia.text = conta.agencia
        text_view_usuario.text = conta.cliente.nome
        text_view_cartao_final_value.text = conta.cartao.numeroDoCartao
    }
}