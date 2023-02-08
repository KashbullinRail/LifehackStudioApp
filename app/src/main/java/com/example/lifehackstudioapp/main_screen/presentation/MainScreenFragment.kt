package com.example.lifehackstudioapp.main_screen.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lifehackstudioapp.R
import com.example.lifehackstudioapp.databinding.FragmentMainScreenBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


const val PUT_TO_DETAIL_FRAGMENT = "PUT_TO_DETAIL_FRAGMENT"


class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val binding by viewBinding(FragmentMainScreenBinding::bind)
    private val viewModel: MainScreenViewModel by viewModel()
    private val adapter: MainCompanyAdapter by lazy {
        MainCompanyAdapter { index ->
            viewModel.processUIEvent(UIEvent.OnCompanyClicked(index))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        binding.rvMainScreen.adapter = adapter

    }

    private fun render(viewState: ViewState){
        when (viewState.state) {
            State.Load -> {
                binding.pbMainScreen.isVisible = true
            }
            State.Content -> {
                binding.pbMainScreen.isVisible = false
                adapter.setData(viewState.companyShown)
            }
            State.Error -> {
               //TODO for future implementation, when the backend is ready
            }
            State.DetailLoad -> {
                binding.pbMainScreen.isVisible = false
                val companyDetail = viewState.companyDetail
                Log.d("TAGG", "${viewState.companyDetail}")
                val bundle = bundleOf(PUT_TO_DETAIL_FRAGMENT to companyDetail)
                findNavController().navigate(R.id.detailScreenFragment, bundle)
            }
        }
    }









}