package com.example.lifehackstudioapp.main_screen.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lifehackstudioapp.R
import com.example.lifehackstudioapp.databinding.FragmentMainScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


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

    private fun render(viewState: ViewState) {
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
                findNavController().navigate(R.id.detailScreenFragment)
            }
        }
    }

}