package helia.hotel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(var array: MutableList<Category>):RecyclerView.Adapter<CategoryAdapter.MyHolder>() {
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var category_name=itemView.findViewById<TextView>(R.id.category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.categoty_item,parent,false)
        return CategoryAdapter.MyHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var temp=array[position]
        holder.category_name.text=temp.name
//        notifyDataSetChanged()
    }
}