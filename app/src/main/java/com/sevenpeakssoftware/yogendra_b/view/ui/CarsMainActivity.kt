package com.sevenpeakssoftware.yogendra_b.view.ui

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenpeakssoftware.yogendra_b.R
import com.sevenpeakssoftware.yogendra_b.compose.ViewModelActivity
import com.sevenpeakssoftware.yogendra_b.databinding.ActivityCarsMainBinding
import com.sevenpeakssoftware.yogendra_b.utilities.getConnectionStatus
import com.sevenpeakssoftware.yogendra_b.view.adapter.CarListAdapter
import com.sevenpeakssoftware.yogendra_b.viewmodel.CarsMainActivityViewModel
import kotlinx.android.synthetic.main.activity_cars_main.*

class CarsMainActivity : ViewModelActivity() {
    private val viewModel by viewModel<CarsMainActivityViewModel>()
    private lateinit var binding: ActivityCarsMainBinding
    private var isRefreshPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cars_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        initializeUI()
        srlCars.setOnRefreshListener {
            isRefreshPressed = true

            if (getConnectionStatus(this)) {
                viewModel.refreshCarPage(isRefreshPressed)
            } else {
                Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_LONG).show()
                srlCars.isRefreshing = false
            }

        }
        viewModel.refreshCarPage(isRefreshPressed)
    }

    private fun initializeUI() {
        car_list_recyclerView.adapter = CarListAdapter()
        car_list_recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}
