package com.example.musica_kuchau

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//                      referencia a una actividad
class ApplicationAdapter(context:Context,feedEntry:ArrayList<FeedEntry>):
    RecyclerView.Adapter<ApplicationAdapter.ViewHolder>() {
    private var localContext:Context?=null
    private var localFeedEntry:ArrayList<FeedEntry>?=null

    init
    {
        localContext=context
        localFeedEntry= feedEntry
    }


    //Inflar el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationAdapter.ViewHolder {
        val layoutInflater: LayoutInflater=LayoutInflater.from(localContext)//Referencia Main Activity
        val view: View=layoutInflater.inflate(R.layout.activity_main,parent,false)
        return ViewHolder(view)
    }

    //Asignar valores a la fila cuando sale de la pantalla
    override fun onBindViewHolder(holder: ApplicationAdapter.ViewHolder, position: Int) {
        val currentFeedEntry:FeedEntry=localFeedEntry!![position]
        holder.textArtist?.text=currentFeedEntry.artist
        holder.textDescription?.text=currentFeedEntry.summary
        holder.textName?.text=currentFeedEntry.name
    }

    override fun getItemCount(): Int {
        return  localFeedEntry?.size?:0
    }

    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        val textName: TextView?= v.findViewById(R.id.textView3)
        val textArtist: TextView?=v.findViewById(R.id.textView2)
        val textDescription: TextView? = v.findViewById(R.id.textView)
    }
}