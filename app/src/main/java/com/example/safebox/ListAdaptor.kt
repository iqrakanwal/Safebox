package com.example.safebox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.safebox.`interface`.onclickListener
import com.example.safebox.model.Safebox

class ListAdaptor(
    var context: Context,
    var images: ArrayList<Safebox>,
    var onclickListener: onclickListener
) :
    RecyclerView.Adapter<ListAdaptor.ImageItem>() {

    inner class ImageItem(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.name)
        var status: TextView = view.findViewById(R.id.status)
        var delete: ImageView = view.findViewById(R.id.delete)
        var edit: ImageView = view.findViewById(R.id.edit)
        /* override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
             onclickListener.onClick()
         }*/
        //   var name: TextView = view.findViewById(R.id.size)
        //   var size: TextView = view.findViewById(R.id.duration)
        //   var createdtime: ImageView = view.findViewById(R.id.thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItem {
        var view: View = LayoutInflater.from(context).inflate(R.layout.safe_box_item, parent, false)
        return ImageItem(view)
    }

    override fun onBindViewHolder(holder: ImageItem, position: Int) {

        holder.name.text = images.get(position).name

        holder.name.setOnClickListener {
            onclickListener.onClick(images.get(position).name, images.get(position).status)
        }
    }

    override fun getItemCount(): Int {

        return images.size

    }


}