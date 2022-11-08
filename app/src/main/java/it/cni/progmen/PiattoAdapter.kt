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
        holder.txtTipo.text = currentPiatto.tipo


    }


    override fun getItemCount(): Int {
        return piattoList.size
    }

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtTitolo = itemView.findViewById<TextView>(R.id.txt_piatto_titolo)
        val txtTipo = itemView.findViewById<TextView>(R.id.txt_piatto_tipo)



    }

}