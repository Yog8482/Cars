package com.sevenpeakssoftware.yogendra_b.view.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenpeakssoftware.yogendra_b.R
import com.sevenpeakssoftware.yogendra_b.compose.ViewModelActivity
import com.sevenpeakssoftware.yogendra_b.databinding.ActivityCarsMainBinding
import com.sevenpeakssoftware.yogendra_b.view.adapter.CarListAdapter
import com.sevenpeakssoftware.yogendra_b.viewmodel.CarsMainActivityViewModel
import kotlinx.android.synthetic.main.activity_cars_main.*

class CarsMainActivity : ViewModelActivity() {
    private val viewModel by viewModel<CarsMainActivityViewModel>()
    private lateinit var binding: ActivityCarsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cars_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initializeUI()
    }

    private fun initializeUI() {
        car_list_recyclerView.adapter = CarListAdapter()
        car_list_recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}
