package it.cni.progmen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class CreaMenu : AppCompatActivity() {

    private lateinit var editxt_titolo : EditText
    private lateinit var editxt_primo : EditText
    private lateinit var editxt_secondo : EditText
    private lateinit var editxt_dolce : EditText
    private lateinit var editxt_ingredienti : EditText
    private lateinit var btn_confermaM : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea_menu)

        editxt_titolo = findViewById(R.id.edtxt_crea_titolo)
        editxt_primo = findViewById(R.id.edtxt_crea_prpiatto)
        editxt_secondo = findViewById(R.id.edtxt_crea_sepiatto)
        editxt_dolce = findViewById(R.id.edtxt_crea_dolce)
        editxt_ingredienti = findViewById(R.id.edtxt_crea_ingredienti)

        btn_confermaM = findViewById(R.id.btn_conferma)

        val calendar = Calendar.getInstance()
        val anno = calendar[Calendar.YEAR]
        val mese = calendar[Calendar.MONTH]
        val giorno = calendar[Calendar.DAY_OF_MONTH]



        btn_confermaM.setOnClickListener {
            try {
                val titolo = editxt_titolo.text.toString()
                val primo = editxt_primo.text.toString()
                val secondo = editxt_secondo.text.toString()
                val dolce = editxt_dolce.text.toString()
                val ingredienti = editxt_ingredienti.text.toString()
                val data = "$giorno/$mese/$anno"
                val menuObjects = Menu("creatorId",titolo,data,primo,secondo,dolce,null,null,null,ingredienti)




            }catch (e:Exception){
                if (editxt_titolo.text.toString().equals("")){
                    Toast.makeText(
                        this,
                        "Errore inserire Titolo"+editxt_titolo.text.toString(),
                              Toast.LENGTH_LONG).show()
                } else if (editxt_ingredienti.text.toString().equals("")){
                    Toast.makeText(
                        this,
                        "Errore inserire Ingredienti",
                        Toast.LENGTH_LONG).show()
                } else if (editxt_titolo.text.toString().equals("") && editxt_ingredienti.text.toString().equals("")){
                    Toast.makeText(
                        this,
                        "Errore inserire Titolo e Ingredienti"+editxt_titolo.text.toString(),
                        Toast.LENGTH_LONG).show()
                }
            }
        }



    }
}