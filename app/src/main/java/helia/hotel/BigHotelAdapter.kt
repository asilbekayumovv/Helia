package helia.hotel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class BigHotelAdapter(
    var array: MutableList<Hotel>,
    var myHotel: MyHotel,
    requireActivity: FragmentActivity
):RecyclerView.Adapter<BigHotelAdapter.MyHolder>() {
    class MyHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var layout=itemView.findViewById<ConstraintLayout>(R.id.cl)
        var reyting=itemView.findViewById<TextView>(R.id.rating)
        var hotel_name=itemView.findViewById<TextView>(R.id.hotel_name)
        var hotel_location=itemView.findViewById<TextView>(R.id.location)
        var hotel_price=itemView.findViewById<TextView>(R.id.price)
    }

    interface MyHotel {
        fun onItemClick(hotel: Hotel)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.hotel_big_item,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var temp=array[position]
        holder.layout.setBackgroundResource(temp.main_photo)
        holder.hotel_name.text=temp.name
        holder.hotel_location.text=temp.location
        holder.reyting.text=temp.rating.toString()
        holder.hotel_price.text="$"+temp.price_pernight.toString()
//        notifyDataSetChanged()
        holder.itemView.setOnClickListener {
            myHotel.onItemClick(temp)
        }
    }
}