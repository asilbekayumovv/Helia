package helia.hotel


class Hotel(
    val name:String,
    val location:String,
    val reviews_num:Int,
    val price_pernight:Int,
    val main_photo:Int,
    var isBooked:Boolean,
    val rating:Double,
    val description:String,
    val isHotels:Boolean,
    val isBathroom2:Boolean,
    val is4Bathroom:Boolean,
    val is4000sqft:Boolean
) {
}