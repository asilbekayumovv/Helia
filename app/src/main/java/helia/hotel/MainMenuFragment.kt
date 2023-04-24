package helia.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import helia.hotel.databinding.FragmentMainMenuBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var list: MutableList<Hotel>
    private lateinit var list2: MutableList<MiniHOtel>
    private var isFav = false
    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var bookingFragment: BookingFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        list = mutableListOf()
        list2 = mutableListOf()
        loadData()
        loadHotel()
        val binding = FragmentMainMenuBinding.inflate(inflater, container, false)


binding.rv2.setHasFixedSize(true)


        var adapter = BigHotelAdapter(list, object : BigHotelAdapter.MyHotel {
            override fun onItemClick(hotel: Hotel) {
                val bundle = bundleOf("hotel" to hotel)
                findNavController().navigate(R.id.action_mainMenuFragment_to_markedFragment, bundle)
            }
            
        }, requireActivity())
            binding.rv2.adapter = adapter


        binding.rv3.setHasFixedSize(true)
        var adapter2 = MiniHotelAdapter(list2, object : MiniHotelAdapter.MyHotel2 {


            override fun onItemClick(hotel: MiniHOtel) {
                val bundle = bundleOf("hotel2" to hotel)
                findNavController().navigate(R.id.action_mainMenuFragment_to_markedFragment, bundle)
            }

        }, requireActivity())
        binding.rv3.adapter = adapter2

        binding.bookmark1.setOnClickListener {
            if (!isFav){
binding.bookmark1.setImageResource(R.drawable.baseline_bookmark_24)
                isFav = true
                binding.bookmark1.tag = 1
                val filter = list.filter { it.status }
                adapter2 = MiniHotelAdapter(
                    filter as MutableList<MiniHOtel>,
object : MiniHotelAdapter.MyHotel2{


    override fun onItemClick(hotel: MiniHOtel) {
        val bundle = bundleOf("hotel" to hotel)
        findNavController().navigate(
            R.id.action_mainMenuFragment_to_markedFragment,
            bundle
        )
    }
}, requireActivity()
                )
                binding.rv3.adapter = adapter2
            }else{
binding.bookmark1.setImageResource(R.drawable.baseline_bookmark_border_24)
                isFav = false
                binding.bookmark1.tag = 0
                adapter2 = MiniHotelAdapter(list2, object : MiniHotelAdapter.MyHotel2{


                    override fun onItemClick(hotel: MiniHOtel) {
                        val bundle = bundleOf("hotel" to hotel)
                        findNavController().navigate(
                            R.id.action_mainMenuFragment_to_markedFragment,
                            bundle
                        )
                    }
                },requireActivity()
                )
binding.rv3.adapter = adapter2
            }
        }
        binding.bookmark1.setOnClickListener {
            if (!isFav){
                binding.bookmark1.setImageResource(R.drawable.baseline_bookmark_24)
                isFav = true
                binding.bookmark1.tag = 1
                val filter = list .filter { it.status }
                adapter = BigHotelAdapter(
                    filter as MutableList<Hotel>,
                    object: BigHotelAdapter.MyHotel{
                        override fun onItemClick(hotel: Hotel) {
                            val bundle = bundleOf("hotel" to hotel)
                            findNavController().navigate(
                                R.id.action_mainMenuFragment_to_markedFragment,
                                bundle
                            )
                        }
                    }, requireActivity()
                )
                binding.rv2.adapter = adapter
            }else{
                binding.bookmark1.setImageResource(R.drawable.baseline_bookmark_border_24)
                isFav = false
                binding.bookmark1.tag = 0
                adapter = BigHotelAdapter(list, object : BigHotelAdapter.MyHotel{
                    override fun onItemClick(hotel: Hotel) {
                        val bundle = bundleOf("hotel" to hotel)
                        findNavController().navigate(
                            R.id.action_mainMenuFragment_to_markedFragment,
                            bundle
                        )
                    }
                },requireActivity()
                )
                binding.rv2.adapter = adapter
            }
        }

binding.search.addTextChangedListener {
val filter = mutableListOf<Hotel>()
if (it != null){
var fav =list
    if (isFav) fav = list.filter { it.status } as MutableList<Hotel>
    for (c in fav){
if (c.name.lowercase().contains(it.toString().lowercase())){
filter.add(c)
}
    }
adapter = BigHotelAdapter(filter, object : BigHotelAdapter.MyHotel {
    override fun onItemClick(hotel: Hotel) {
val bundle = bundleOf("hotel" to hotel)
        findNavController().navigate(
            R.id.action_mainMenuFragment_to_markedFragment,
            bundle
        )
    }
    
},requireActivity())
    binding.rv2.adapter = adapter
}
}
        binding.search.addTextChangedListener {
            val filter = mutableListOf<MiniHOtel>()
            if (it != null){
                var fav =list2
                if (isFav) fav = list2.filter { it.status } as MutableList<MiniHOtel>
                for (c in fav){
                    if (c.name.lowercase().contains(it.toString().lowercase())){
                        filter.add(c)
                    }
                }
                adapter2 = MiniHotelAdapter(filter, object : MiniHotelAdapter.MyHotel2 {


                    override fun onItemClick(hotel: MiniHOtel) {
                        val bundle = bundleOf("hotel" to hotel)
                        findNavController().navigate(
                            R.id.action_mainMenuFragment_to_markedFragment,
                            bundle
                        )
                    }

                },requireActivity())
                binding.rv3.adapter = adapter2
            }
        }




        return binding.root
    }

    private fun loadHotel() {

     list2.add(
         MiniHOtel(
         "Ko'cha city",
         "Ko'cha",
         45,
         455,
         R.drawable.hotel2_mini,
         false,
         4.8,
         "Amazing Hotel",
         false
     )
     )
        list2.add(MiniHOtel(
            "Ko'cha city",
            "Ko'cha",
            45,
            455,
            R.drawable.hotel2_mini,
            false,
            4.8,
            "Amazing Hotel",
            false
     ))
        list2.add(MiniHOtel(
            "Tashqari city",
            "Ko'cha",
            45,
            455,
            R.drawable.hotel2_mini,
            false,
            4.8,
            "Amazing Hotel",
            false
        ))
        list2.add(MiniHOtel(
            "Shamol city",
            "Ko'cha",
            45,
            455,
            R.drawable.hotel2_mini,
            false,
            4.8,
            "Amazing Hotel",
            false
        ))
    }

    private fun loadData() {
        list.add(
Hotel(
    "Andijan city",
    "Andijan city",
500,
    999,
    R.drawable.hotel2,
    false,
    4.8,
    "Amazing Hotel",
    false
)
        )
        list.add(
            Hotel(
                "Qashqadarya city",
                "Andijan city",
                500,
                999,
                R.drawable.hotel2,
                false,
                4.8,
                "Amazing Hotel",
                false
            )
        )
        list.add(
            Hotel(
                "Fergana city",
                "Andijan city",
                500,
                999,
                R.drawable.hotel2,
                false,
                4.8,
                "Amazing Hotel",
                false
            )
        )
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}