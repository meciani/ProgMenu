package it.cni.progmen

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PiattoAdapter (val context : Context, val piattoList: ArrayList<Menu>):
    RecyclerView.Adapter<PiattoAdapter.MenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.layout_piatto,parent,false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        var currentPiatto = piattoList[position]
        holder.txtTitolo.text = currentPiatto.piatto
        holder.txtTitolo2.text = currentPiatto.piatto2
        holder.txtTitolo3.text = currentPiatto.piatto3
        holder.txtTipo.text = currentPiatto.tipo
        holder.txtTipo2.text = currentPiatto.tipo2
        holder.txtTipo3.text = currentPiatto.tipo3


    }


    override fun getItemCount(): Int {
        return piattoList.size
    }

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtTitolo = itemView.findViewById<TextView>(R.id.txt_piatto_titolo)
        val txtTitolo2 = itemView.findViewById<TextView>(R.id.txt_piatto2_titolo)
        val txtTitolo3 = itemView.findViewById<TextView>(R.id.txt_piatto3_titolo)
        val txtTipo = itemView.findViewById<TextView>(R.id.txt_piatto_tipo)
        val txtTipo2 = itemView.findViewById<TextView>(R.id.txt_piatto2_tipo)
        val txtTipo3 = itemView.findViewById<TextView>(R.id.txt_piatto3_tipo)




    }

}