package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var promoAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()
    private val promoList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        // 🔹 ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        binding.recyclerViewPromos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        promoAdapter = ProductAdapter(promoList)
        binding.recyclerViewPromos.adapter = promoAdapter

        // 🔹 โหลดข้อมูล
        loadProducts()
        loadPromotions()
    }

    private fun loadProducts() {
        productList.add(Product("Superstar Shoes", "3000 บาท", R.drawable.fu))
        productList.add(Product("Daily 4.0 Shoes", "2200 บาท", R.drawable.daily))
        productList.add(Product("NMD_R1 Shoes", "5500 บาท", R.drawable.nmd))
        productList.add(Product("Advantage Shoes", "2300 บาท", R.drawable.gw))
        productAdapter.notifyDataSetChanged()
    }

    private fun loadPromotions() {
        promoList.add(Product("Superstar Shoes", "ลดเหลือ 2000 บาท", R.drawable.fu))
        promoList.add(Product("Daily 4.0 Shoes", "ลดเหลือ 1320 บาท", R.drawable.daily))
        promoList.add(Product("NMD_R1 Shoes", "ลดเหลือ 3300 บาท", R.drawable.nmd))
        promoList.add(Product("Advantage Shoes", "ลดเหลือ 1380 บาท", R.drawable.gw))
        promoAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
