package com.example.mvvm_countries.view

import android.content.*
import android.os.*
import android.view.*
import androidx.appcompat.app.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_countries.databinding.*
import com.example.mvvm_countries.viewmodel.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*println("******onCreate()")
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }*/

        /** we can enable later as we are preparing for interview to checking the
         * two activities are working or not
         */
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        viewModel.refresh()

        binding.countriesList.layoutManager = LinearLayoutManager(this)
        binding.countriesList.adapter = countriesAdapter
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        /**
         * Here we are going to receive the countries list from ViewModel
         */
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                binding.countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it)
            }
        })
        /**
         * Here we are checking for the error
         */
        viewModel.countryLoader.observe(this, Observer { isError ->
            isError.let { binding.listError.visibility = if (it) View.VISIBLE else View.GONE }

        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading.let {
                binding.loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.listError.visibility = View.GONE
                    binding.countriesList.visibility = View.GONE
                }
            }
        })

    }

    override fun onStart() {
        super.onStart()
        println("******onStart()")
    }

    override fun onResume() {
        super.onResume()
        println("******onResume()")
    }

    override fun onPause() {
        super.onPause()
        println("******onPause()")
    }
    override fun onStop() {
        super.onStop()
        println("******onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("******onDestroy()")
    }
    override fun onRestart() {
        super.onRestart()
        println("******onRestart()")
    }

}