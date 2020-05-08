package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter.HospitalizacijaAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import kotlinx.android.synthetic.main.fragment_cekaonica.searchET
import kotlinx.android.synthetic.main.fragment_hospitalizovani.*
import kotlinx.android.synthetic.main.hospitalizacija_lista.*
import timber.log.Timber

class HospitalizovaniFragment : Fragment(R.layout.fragment_hospitalizovani){
    private val sharedViewModel : SharedViewModel by activityViewModels()

    private lateinit var hospitalizacijaAdapter: HospitalizacijaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initObservers()
        initListeners()
        initRecycler()
    }

    private fun initObservers(){
        sharedViewModel.getHospitalizovaniData().observe(viewLifecycleOwner, Observer {
            hospitalizacijaAdapter.submitList(it)
        })

    }

    private fun initListeners(){

        searchET.doAfterTextChanged {
            sharedViewModel.pretraziPacijenta(SharedViewModel.HOSPITALIZOVAN, searchET.text.toString())
            hospitalizacijaAdapter.notifyDataSetChanged()
        }

    }

    private val kartonDugme : (Pacijent) ->Unit = {
        //Otvori karton
        Timber.e("Otvara se karton")

    }


    private val otpustiDugme : (Pacijent) -> Unit = {
        sharedViewModel.premestiPacijenta(it, SharedViewModel.HOSPITALIZOVAN, SharedViewModel.OTPUSTEN)
        sharedViewModel.pretraziPacijenta(SharedViewModel.HOSPITALIZOVAN, searchET.text.toString())
        hospitalizacijaAdapter.notifyDataSetChanged()
    }

    private fun initRecycler(){

        rvHospitalizovani.layoutManager = LinearLayoutManager(activity)
        hospitalizacijaAdapter = HospitalizacijaAdapter(PacijentDiff(), kartonDugme, otpustiDugme)
        rvHospitalizovani.adapter = hospitalizacijaAdapter

    }

    override fun onPause() {
        super.onPause()
        sharedViewModel.pretraziPacijenta(SharedViewModel.HOSPITALIZOVAN, "")
    }

    override fun onResume() {
        super.onResume()
        sharedViewModel.pretraziPacijenta(SharedViewModel.HOSPITALIZOVAN, searchET.text.toString())
    }
}