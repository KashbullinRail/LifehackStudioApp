package com.example.lifehackstudioapp.detail_screen.presentor

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.lifehackstudioapp.R
import com.example.lifehackstudioapp.databinding.FragmentDetailScreenBinding
import com.example.lifehackstudioapp.main_screen.presentation.URL_IMAGE
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailScreenFragment : Fragment(R.layout.fragment_detail_screen) {

    private val binding by viewBinding(FragmentDetailScreenBinding::bind)
    private val viewModel: DetailScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.mainScreenFragment)
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

    }

    @SuppressLint("SetTextI18n")
    private fun render(viewState: ViewState) {

        when (viewState.state) {
            State.Load -> {
                //TODO for future implementation, when the backend is ready
            }
            State.Content -> {
                with(binding) {

                    tvCompanyNameDetail.text = viewState.companyDetail.name
                    tvDescriptionDetail.text = viewState.companyDetail.description
                    tvLatitudeDetail.text = "${viewState.companyDetail.latitude} " +
                            "  ${viewState.companyDetail.longitude}"
                    tvWebsiteAdressDetail.text = viewState.companyDetail.websiteAddress
                    tvPhoneNumberDetail.text = viewState.companyDetail.phoneNumber
                    Glide
                        .with(ivCompanyImgDetail.context)
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
                //TODO for future implementation, when the backend is ready
            }
        }

    }

}