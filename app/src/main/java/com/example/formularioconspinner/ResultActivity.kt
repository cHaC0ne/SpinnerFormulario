package com.example.formularioconspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formularioconspinner.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var b: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityResultBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.bVolver.setOnClickListener {
            onBackPressed()
        }
    }
}
