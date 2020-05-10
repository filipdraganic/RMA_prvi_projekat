package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_stanje.*

class StanjeFragment : Fragment(R.layout.fragment_stanje){

    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init(){
        initObservers()
    }

    private fun initObservers(){

        sharedViewModel.getCekaonicaStanje().observe(viewLifecycleOwner, Observer {
            cekaonicaBroj.text = it.size.toString()
        })

        sharedViewModel.getHospitalizovaniStanje().observe(viewLifecycleOwner, Observer {
            hospitalizovaniBroj.text = it.size.toString()
        })


        sharedViewModel.getOtpusteniStanje().observe(viewLifecycleOwner, Observer {
            otpusteniBroj.text = it.size.toString()
        })
    }


}