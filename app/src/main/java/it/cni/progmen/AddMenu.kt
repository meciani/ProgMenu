package it.cni.progmen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AddMenu : AppCompatActivity() {


    private lateinit var piattoRecyclerView: RecyclerView
    private lateinit var piattoAdapter : PiattoAdapter
    private lateinit var piattoList : ArrayList<Menu>


    private lateinit var btn_menuVel: Button
    private lateinit var btn_menuBase: Button
    private lateinit var btn_menuAva: Button
    private lateinit var btn_CreaMenu: Button
    private lateinit var btn_salvaMenu : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)

        btn_menuVel = findViewById(R.id.btn_menuV)
        btn_menuBase = findViewById(R.id.btn_menuB)
        btn_menuAva = findViewById(R.id.btn_menuS)
        btn_CreaMenu = findViewById(R.id.btn_creaM)
        btn_salvaMenu = findViewById(R.id.btn_salva)

        piattoRecyclerView = findViewById(R.id.ContMReciclerView)
        piattoList = ArrayList()
        piattoAdapter = PiattoAdapter(this,piattoList)

        piattoRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        piattoRecyclerView.adapter = piattoAdapter

        btn_menuVel.setOnClickListener {
            preparazioneMenuVeloce()
            piattoAdapter.notifyDataSetChanged()
        }

        btn_menuBase.setOnClickListener {
            preparazioneMenuBase()
            piattoAdapter.notifyDataSetChanged()
        }

        btn_menuAva.setOnClickListener {
            preparazioneMenuAvanzato()
            piattoAdapter.notifyDataSetChanged()
        }






    }


    private fun preparazioneMenuVeloce(){

        var piatto = Menu("Marco","menuVeloce","currentdata"
            ,"pasta in bianco","pasta","pasta")
        piattoList.add(piatto)

        piatto = Menu("Marco","menuVeloce","currentdata"
            ,"Hamburger","carne","Hamburger")
        piattoList.add(piatto)

        piatto = Menu("Marco","menuVeloce","currentdata"
            ,"Biscotti","Dolce","Biscotti")
                piattoList.add(piatto)

    }

    private fun preparazioneMenuBase(){

        var piatto = Menu("Marco","menuBase","currentdata"
            ,"pasta con le vongole","pasta con pesce","pasta,vongole")
        piattoList.add(piatto)

        piatto = Menu("Marco","menuBase","currentdata"
            ,"Costata","carne","Carne")
        piattoList.add(piatto)

        piatto = Menu("Marco","menuBase","currentdata"
            ,"Torta","Dolce","Torta supermercato")
        piattoList.add(piatto)

    }

    private fun preparazioneMenuAvanzato(){

        var piatto = Menu("Marco","menuAvanzato","currentdata"
            ,"Risotto ai Porcini","Risotto ai funghi","riso,porcini")
        piattoList.add(piatto)

        piatto = Menu("Marco","menuAvanzato","currentdata"
            ,"Aragosta","pesce","Aragosta")
        piattoList.add(piatto)

        piatto = Menu("Marco","menuAvanzato","currentdata"
            ,"Tiramisu","Dolce","Savoiardi,caffe,Mascarpone,cacao")
        piattoList.add(piatto)
    }



}