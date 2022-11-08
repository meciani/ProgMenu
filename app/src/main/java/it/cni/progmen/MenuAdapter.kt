package it.cni.progmen

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter (val context : Context,val menuList: ArrayList<Menu>):
RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
       val view : View = LayoutInflater.from(context).inflate(R.layout.layout_menu,parent,false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        var currentMenu = menuList[position]
        holder.txtTitolo.text = currentMenu.titolo
        holder.txtData.text = currentMenu.data

        holder.itemView.setOnClickListener {
            val intent = Intent(context,VisualizzaMenu::class.java)

            intent.putExtra("titolo",currentMenu.titolo)
            intent.putExtra("piatto",currentMenu.piatto)
            intent.putExtra("tipo",currentMenu.tipo)

        }

    }


    override fun getItemCount(): Int {
        return menuList.size
    }

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtTitolo = itemView.findViewById<TextView>(R.id.txt_menu_titolo)
        val txtData = itemView.findViewById<TextView>(R.id.txt_menu_data)


    }




}