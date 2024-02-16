package com.alysson.appcardpioonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.alysson.appcardpioonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
        binding.buttonToCheck.setOnClickListener(this)
        binding.buttonMakeaWish.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_Calculate) {
            calculate()
        } else if (v.id == R.id.button_MakeaWish) {
            makeaWish()
        } else if (v.id == R.id.button_ToCheck) {
            toCheck()
        }
    }

    private fun toCheck() {
        val tableNum = binding.editTableNumber.text.toString()
        val messageTable = getString(R.string.text_tableStatus) + " " + "✅"
        val messageTableNocheck = getString(R.string.text_tableStatus) + " " + "❌"
        val messageTableInvalid = "Digite o valor da mesa"

        if (tableNum.toString().isEmpty()) {
            binding.textTableStatus.text = messageTableInvalid
        } else {
            if (tableNum.toInt() == 1) {
                binding.textTableStatus.text = messageTable
            } else if (tableNum.toInt() == 2) {
                binding.textTableStatus.text = messageTable
            } else {
                binding.textTableStatus.text = messageTableNocheck
            }
        }

    }
    private fun makeaWish(){
        var sum = boxsCheck()
        if (sum == 0f){
            calculate()
            Toast.makeText(this, "Marque a opcao pertinente ao seu pedido", Toast.LENGTH_SHORT).show()
        }else{
            calculate()
            Toast.makeText(this, "pedido realizado com sucesso", Toast.LENGTH_SHORT).show()
        }
    }
    private fun calculate(){
        var sum = boxsCheck()
        val money= "R$ "
        binding.textResult.text= "$money$sum"

    }
    private fun boxsCheck():Float{
        var sum = 0f
        if (binding.checkboxStarterDishes01.isChecked.not()
            && binding.checkboxStarterDishes02.isChecked.not()
            && binding.checkboxStarterDishes03.isChecked.not()
            && binding.checkboxStarterDishes04.isChecked.not()
            && binding.checkboxMainDishes01.isChecked.not()
            && binding.checkboxMainDishes02.isChecked.not()
            && binding.checkboxDrinks01.isChecked.not()
            && binding.checkboxDrinks02.isChecked.not()
            && binding.checkboxDesserts01.isChecked.not()
            && binding.checkboxDesserts02.isChecked.not()){
            Toast.makeText(this, "Clique em pelo menos uma opção para calcular o seu perdido", Toast.LENGTH_SHORT).show()
        }
        if (binding.checkboxStarterDishes01.isChecked){
            sum +=10.10f
        }
        if (binding.checkboxStarterDishes02.isChecked){
            sum +=15.00f
        }
        if (binding.checkboxStarterDishes03.isChecked){
            sum +=20.00f
        }
        if (binding.checkboxStarterDishes04.isChecked){
            sum +=25.00f
        }

        if (binding.checkboxMainDishes01.isChecked){
            sum += 24f
        }
        if (binding.checkboxMainDishes02.isChecked){
            sum += 15f
        }

        if (binding.checkboxDrinks01.isChecked){
            sum+=10.60f
        }
        if (binding.checkboxDrinks02.isChecked){
            sum+=5f
        }

        if(binding.checkboxDesserts01.isChecked){
            sum+=15.90f
        }
        if(binding.checkboxDesserts02.isChecked){
            sum+=18.15f
        }

        return sum
    }

}