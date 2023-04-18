package helia.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
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
        val binding = FragmentMainMenuBinding.inflate(inflater, container, false)

        binding.search.addTextChangedListener {
            val filter = mutableListOf<Hotel>()
            val filter2 = mutableListOf<MiniHOtel>()
            if (it != null) {
                for (c in filter) {


                    if (c.name.lowercase().contains(it.toString().lowercase())) {
                        filter.add(c)
                    }
                }
                    var adapter = BigHotelAdapter(filter)
                    binding.rv2.adapter = adapter

            }
            for (d in filter2) {

                if (d.name.lowercase().contains(it.toString().lowercase())){
                    filter2.add(d)
                }
            }
            var adapter2 = MiniHotelAdapter(filter2)
            binding.rv3.adapter = adapter2
        }


        val category = mutableListOf<Category>()
        var adapter3 = CategoryAdapter(category)
        binding.rv1.adapter = adapter3

        category.add(Category("Recommendet"))
        category.add(Category("Popular"))

        val list = mutableListOf<Hotel>()
        var adapter = BigHotelAdapter(list)
        binding.rv2.adapter = adapter

        list.add(Hotel("Andijan city", "Andijan city", 555, 789, R.drawable.hotel2, true, 4.8, "Amazing Hotel"))
        list.add(Hotel("Qashqadarya city", "Andijan city", 555, 789, R.drawable.hotel2, true, 4.8, "Amazing Hotel"))
        list.add(Hotel("Samarkand city", "Andijan city", 555, 789, R.drawable.hotel2, true, 4.8, "Amazing Hotel"))
        list.add(Hotel("Namangan city", "Andijan city", 555, 789, R.drawable.hotel2, true, 4.8, "Amazing Hotel"))


        var list2 = mutableListOf<MiniHOtel>()
        var adapter2 = MiniHotelAdapter(list2)
        binding.rv3.adapter = adapter2

        list2.add(MiniHOtel("Tashkent city", "Tashkent city", 655, 999, R.drawable.hotel2_mini, true, 4.6, "Wonderful hotel"))
        list2.add(MiniHOtel("Tashkent city", "Tashkent city", 655, 999, R.drawable.hotel2_mini, true, 4.6, "Wonderful hotel"))
        list2.add(MiniHOtel("Tashkent city", "Tashkent city", 655, 999, R.drawable.hotel2_mini, true, 4.6, "Wonderful hotel"))
        list2.add(MiniHOtel("Tashkent city", "Tashkent city", 655, 999, R.drawable.hotel2_mini, true, 4.6, "Wonderful hotel"))
        return binding.root
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