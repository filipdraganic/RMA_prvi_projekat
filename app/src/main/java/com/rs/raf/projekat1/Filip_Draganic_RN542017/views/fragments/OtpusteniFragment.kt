package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter.OtpustenAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_otpusteni.*

class OtpusteniFragment : Fragment(R.layout.fragment_otpusteni){


    private val sharedViewModel : SharedViewModel by activityViewModels()

    private lateinit var otpustenAdapter: OtpustenAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initObservers()
        initListeners()
        initRecycler()
    }

    private fun initListeners(){
        searchET.doAfterTextChanged {
            sharedViewModel.pretraziPacijenta(SharedViewModel.OTPUSTEN, searchET.text.toString())
            otpustenAdapter.notifyDataSetChanged()
        }
    }


    private fun initRecycler(){
        rvOtpusteni.layoutManager = LinearLayoutManager(activity)
        otpustenAdapter = OtpustenAdapter(PacijentDiff())
        rvOtpusteni.adapter = otpustenAdapter
    }

    private fun initObservers(){
        sharedViewModel.getOtpusteniData().observe(viewLifecycleOwner, Observer {
            otpustenAdapter.submitList(it)
        })
    }

    override fun onPause() {
        super.onPause()
        sharedViewModel.pretraziPacijenta(SharedViewModel.OTPUSTEN, "")
    }

    override fun onResume() {
        super.onResume()
        sharedViewModel.pretraziPacijenta(SharedViewModel.OTPUSTEN, searchET.text.toString())
    }
}