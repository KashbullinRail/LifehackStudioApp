package com.example.lifehackstudioapp.detail_screen.presentor

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.lifehackstudioapp.R
import com.example.lifehackstudioapp.databinding.FragmentDetailScreenBinding
import com.example.lifehackstudioapp.detail_screen.domain.CompanyDetailModel
import com.example.lifehackstudioapp.main_screen.presentation.URL_IMAGE
import org.koin.androidx.viewmodel.ext.android.viewModel

const val PUT_TO_DETAIL_FRAGMENT = "PUT_TO_DETAIL_FRAGMENT"


class DetailScreenFragment : Fragment(R.layout.fragment_detail_screen) {

    private val binding by viewBinding(FragmentDetailScreenBinding::bind)
    private val viewModel: DetailScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.mainScreenFragment)
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        val detailCompany = arguments?.getSerializable(PUT_TO_DETAIL_FRAGMENT)
        viewModel.processUIEvent(UIEvent.OnDetailCompanyGet(detailCompany as CompanyDetailModel))

    }

    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
                binding.pbDetailScreen.isVisible = true
            }
            State.Content -> {
                with(binding) {
                    pbDetailScreen.isVisible = false

                    tvCompanyNameDetail.text = viewState.companyDetail.name
                    tvDescriptionDetail.text = viewState.companyDetail.description
                    tvLatitudeDetail.text = viewState.companyDetail.latitude
                    tvLongtitudeDetail.text = viewState.companyDetail.longitude
                    tvWebsiteAdressDetail.text = viewState.companyDetail.websiteAddress
                    tvPhoneNumberDetail.text = viewState.companyDetail.phoneNumber
                    Glide
                        .with(this@DetailScreenFragment)
                        .load(URL_IMAGE + viewState.companyDetail.image)
                        .placeholder(R.drawable.ic_image)
                        .error(R.drawable.ic_image_not_supported)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .centerCrop()
                        .into(ivCompanyImgDetail)
                }
            }
            State.PhoneCallOpen -> {

            }
            State.WebsiteOpen -> {

            }
            State.Error -> {
                ////TODO for future implementation, when the backend is ready
            }
        }

    }

}