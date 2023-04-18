package helia.hotel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MiniHotelAdapter(var array:MutableList<MiniHOtel>):RecyclerView.Adapter<MiniHotelAdapter.MyHolder>() {
    class MyHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var miniHotelName=itemView.findViewById<TextView>(R.id.mini_hotel_name)
        var miniHotelLocation=itemView.findViewById<TextView>(R.id.mini_hotel_location)
        var miniHotelPrice=itemView.findViewById<TextView>(R.id.mini_hotel_price)
        var miniHotelImage=itemView.findViewById<ConstraintLayout>(R.id.mini_hotel_image)
        var miniHotelIsBooked=itemView.findViewById<MaterialButton>(R.id.mini_hotel_isBooked)
        var miniHotelReveiws=itemView.findViewById<TextView>(R.id.mini_hotel_review)
        var miniHotelRating=itemView.findViewById<TextView>(R.id.mini_hotel_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hotel_mini_item,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var temp=array[position]
        holder.miniHotelImage.setBackgroundResource(temp.main_photo)
        holder.miniHotelLocation.text=temp.location
        holder.miniHotelName.text=temp.name
        holder.miniHotelPrice.text="$"+temp.price_pernight
        holder.miniHotelRating.text=temp.rating.toString()
        holder.miniHotelReveiws.text=temp.reviews_num.toString()+"reviews"
        holder.miniHotelIsBooked.setOnClickListener {
            temp.isBooked=true;
        }
        if (temp.isBooked){
            holder.miniHotelIsBooked.setIconResource(R.drawable.baseline_bookmark_24)
        }
//        notifyDataSetChanged()
    }
}