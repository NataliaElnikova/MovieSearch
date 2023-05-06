package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.filament.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun initButtons() {

        fun onClickToast(view: View) {
            Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
        }
    }
}
