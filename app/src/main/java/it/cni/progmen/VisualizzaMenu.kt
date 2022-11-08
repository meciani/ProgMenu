package it.cni.progmen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class VisualizzaMenu : AppCompatActivity() {

    private lateinit var titolo_menu : TextView
    private lateinit var data_menu : TextView
    private lateinit var ctn_menu : TextView
   private lateinit var btn_ind :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizza_menu)

         titolo_menu = findViewById(R.id.txt_visualizza_titolo)
        val titM = intent.getStringExtra("titolo").toString()
        titolo_menu.setText(titM)

        data_menu = findViewById(R.id.txt_visualizza_data)
        val dataM = intent.getStringExtra("data").toString()
        titolo_menu.setText(dataM)

        ctn_menu = findViewById(R.id.txt_visualizza_ctnMenu)
        val ctnM = intent.getStringExtra("piatto").toString()
        ctn_menu.setText(ctnM)

        btn_ind = findViewById(R.id.btn_back)

        btn_ind.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }
}