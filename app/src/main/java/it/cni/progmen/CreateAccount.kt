package it.cni.progmen

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class CreateAccount : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var myDbRef : DatabaseReference

    private lateinit var editxt_nome : EditText
    private lateinit var editxt_email : EditText
    private lateinit var editxt_pass : EditText
    private lateinit var btn_CreAcc : Button
    private lateinit var btn_LogIn : Button
    private var mostra_password: ImageView? = null
    private var visibilita_password = false




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        mAuth  = FirebaseAuth.getInstance()

        editxt_nome = findViewById(R.id.editxt_Name)
        editxt_email = findViewById(R.id.editxt_Email)
        editxt_pass = findViewById(R.id.editxt_Password)
        btn_CreAcc = findViewById(R.id.btn_creaAcc)
        btn_LogIn = findViewById(R.id.btn_logIn)
        mostra_password = findViewById(R.id.mostraPassword)

        mostraPassword(visibilita_password)
        mostra_password!!.setOnClickListener {
            visibilita_password = !visibilita_password
            mostraPassword(visibilita_password)
        }

        btn_CreAcc.setOnClickListener {
            try{
                val nome = editxt_nome.text.toString()
                val email = editxt_email.text.toString()
                val password = editxt_pass.text.toString()

                creaAccount(nome,email,password)

            }catch(e:Exception){
                if (editxt_email.text.toString().equals("") && editxt_pass.text.toString().equals("")) {
                    Toast.makeText(this, "Errore inserire email e password", Toast.LENGTH_SHORT)
                        .show()
                } else if(editxt_email.text.toString().equals("")){
                    Toast.makeText(this, "Errore inserire email", Toast.LENGTH_SHORT)
                        .show()
                } else if(editxt_pass.text.toString().equals("")){
                    Toast.makeText(this, "Errore inserire password", Toast.LENGTH_SHORT)
                        .show()
                }else if(editxt_nome.text.toString().equals("")){
                    Toast.makeText(this, "Errore inserire nome", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }

        btn_LogIn.setOnClickListener {
            try {
                val email = editxt_email.text.toString()
                val password = editxt_pass.text.toString()

                loginAccount(email, password)

            }catch (e: Exception ){

                if (editxt_email.text.toString().equals("") && editxt_pass.text.toString().equals("")) {
                    Toast.makeText(this, "Errore inserire email e password", Toast.LENGTH_SHORT)
                        .show()
                } else if(editxt_email.text.toString().equals("")){
                    Toast.makeText(this, "Errore inserire email", Toast.LENGTH_SHORT)
                        .show()
                } else if(editxt_pass.text.toString().equals("")){
                    Toast.makeText(this, "Errore inserire password", Toast.LENGTH_SHORT)
                        .show()
                }else if(editxt_nome.text.toString().equals("")){
                    Toast.makeText(this, "Errore inserire nome", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }



    }



    private fun creaAccount(nome:String,email:String,password:String){
        mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task->
                if (task.isSuccessful){

                    addUtenteToDb(nome,email,mAuth.currentUser?.uid!!)

                    val intent = Intent(this,MainActivity::class.java)
                    intent.putExtra("nome",nome)
                    finish()
                    startActivity(intent)
                } else {
                    Log.w(ContentValues.TAG,"createUserWithEmailAndPassword: Fallita",task.exception)
                    Toast.makeText(baseContext,"Autenticazione fallita",Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun loginAccount(email:String,password: String){
        mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) { task->
                if(task.isSuccessful){
                    val intent = Intent(this,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Utente non registrato", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    private fun addUtenteToDb(nome:String,email:String,uid: String){
        myDbRef = FirebaseDatabase.getInstance().getReference()
        myDbRef.child("utente").child(uid).setValue(Utente(nome,email,uid))
    }


    private fun mostraPassword(visibilitaPass: Boolean){
        var passwordEditxt = findViewById<EditText>(R.id.editxt_Password)
        if(visibilitaPass){
            passwordEditxt.transformationMethod = HideReturnsTransformationMethod.getInstance()
            mostra_password!!.setImageResource(R.drawable.ic_baseline_visibility_off_24)
        } else {
            passwordEditxt.transformationMethod = HideReturnsTransformationMethod.getInstance()
            mostra_password!!.setImageResource(R.drawable.ic_visibility)
        }
        passwordEditxt.setSelection(passwordEditxt.length())
    }


}