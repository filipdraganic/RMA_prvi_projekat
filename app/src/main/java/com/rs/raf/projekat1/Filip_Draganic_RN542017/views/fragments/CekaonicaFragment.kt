package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter.CekaonicaAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_cekaonica.*

class CekaonicaFragment : Fragment(R.layout.fragment_cekaonica){
    private val sharedViewModel : SharedViewModel by activityViewModels()

    private lateinit var cekaonicaAdapter: CekaonicaAdapter

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
            sharedViewModel.pretraziPacijenta(SharedViewModel.CEKAONICA, searchET.text.toString())
            cekaonicaAdapter.notifyDataSetChanged()
        }
    }


    private val zdravoDugme: (Pacijent) -> Unit = {
        sharedViewModel.premestiPacijenta(it, SharedViewModel.CEKAONICA, SharedViewModel.OTPUSTEN)
        sharedViewModel.pretraziPacijenta(SharedViewModel.CEKAONICA, searchET.text.toString())
        cekaonicaAdapter.notifyDataSetChanged()
    }

    private val hospitalizacijaDugme: (Pacijent) -> Unit = {
        sharedViewModel.premestiPacijenta(it, SharedViewModel.CEKAONICA, SharedViewModel.HOSPITALIZOVAN)
        sharedViewModel.pretraziPacijenta(SharedViewModel.CEKAONICA, searchET.text.toString())
        cekaonicaAdapter.notifyDataSetChanged()
    }

    private fun initRecycler(){
        rvCekaonica.layoutManager = LinearLayoutManager(activity)
        cekaonicaAdapter = CekaonicaAdapter(PacijentDiff(),  zdravoDugme, hospitalizacijaDugme)
        rvCekaonica.adapter = cekaonicaAdapter
    }

    private fun initObservers(){
        sharedViewModel.getCekaonicaData().observe(viewLifecycleOwner, Observer{
            cekaonicaAdapter.submitList(it)
        })
    }

    override fun onPause() {
        super.onPause()
        sharedViewModel.pretraziPacijenta(SharedViewModel.CEKAONICA, "")
    }

    override fun onResume() {
        super.onResume()
        sharedViewModel.pretraziPacijenta(SharedViewModel.CEKAONICA, searchET.text.toString())
    }
}