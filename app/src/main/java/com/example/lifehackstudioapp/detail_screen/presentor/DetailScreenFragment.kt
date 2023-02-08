package com.example.lifehackstudioapp.detail_screen.presentor

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
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


const val HTTPS = "https://www."
const val WWW = "www."


class DetailScreenFragment : Fragment(R.layout.fragment_detail_screen) {

    private val binding by viewBinding(FragmentDetailScreenBinding::bind)
    private val viewModel: DetailScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.mainScreenFragment)
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        with(binding) {
            tvPhoneNumberDetail.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnPhoneClicked)
            }
            tvWebsiteAdressDetail.setOnClickListener {
                viewModel.processUIEvent(UIEvent.OnWebsiteClicked)
            }
            tvLatitudeDetail.setOnClickListener {

            }
        }

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
                val r = Regex(REGEX_PHONE)
                if (r.matches(viewState.companyDetail.phoneNumber)) {
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel: + ${viewState.companyDetail.phoneNumber}")
                    startActivity(intent)
                } else Toast.makeText(
                    requireContext().applicationContext,
                    requireActivity().getString(R.string.phone_number_incorrected),
                    Toast.LENGTH_LONG
                ).show()
            }
            State.WebsiteOpen -> {
                val web = viewState.companyDetail.websiteAddress
                var webSite = ""
                var str = ""
                if (web.isNotEmpty()) {
                    if (!(web.startsWith(HTTPS))) {
                        if (web.startsWith(WWW)) {
                            webSite = web.replaceFirst(WWW, HTTPS)
                            str = "  "
                            println("YYYYYY= $webSite    RRRRR= $str")
                        } else {
                            str = web.first().toString()
                            webSite = web.replaceFirst(str, "${HTTPS}$str")
                        }
                        println("888888= $webSite")
                    }

                    if (webSite.startsWith(HTTPS)) {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webSite))
                            startActivity(intent)
                        } catch (e: ActivityNotFoundException) {
                            Toast.makeText(
                                requireContext(),
                                requireActivity().getString(R.string.web_incorrected),
                                Toast.LENGTH_LONG
                            ).show()
                            e.printStackTrace()
                        }
                    }
                }


            }
            State.Error -> {
                //TODO for future implementation, when the backend is ready
            }
        }

    }

}