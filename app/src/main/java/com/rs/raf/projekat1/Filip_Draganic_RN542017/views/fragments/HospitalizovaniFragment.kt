package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity.KartonActivity
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter.HospitalizacijaAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_hospitalizovani.*
import timber.log.Timber

class HospitalizovaniFragment : Fragment(R.layout.fragment_hospitalizovani){
    private val sharedViewModel : SharedViewModel by activityViewModels()

    private lateinit var hospitalizacijaAdapter: HospitalizacijaAdapter

    companion object{
        const val PACIJENT = "PACIJENT"
        const val PACIJENT_KOD = 1337
    }

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
            hospitalizacijaAdapter.notifyDataSetChanged()
        })

    }

    private fun initListeners(){

        searchET.doAfterTextChanged {
            sharedViewModel.pretraziPacijenta(SharedViewModel.HOSPITALIZOVAN, searchET.text.toString())
            hospitalizacijaAdapter.notifyDataSetChanged()
        }

    }

    private val kartonDugme : (Pacijent) ->Unit = {

        val intent = Intent(activity, KartonActivity::class.java)
        intent.putExtra(PACIJENT, it)
        startActivityForResult(intent, PACIJENT_KOD)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PACIJENT_KOD){
            if(resultCode == Activity.RESULT_OK){
                val res = data?.getParcelableExtra<Pacijent>(PACIJENT)
                if (res != null) {
                    sharedViewModel.overwritePacijenta(res)
                    Timber.e("Stiglo kao rezultat  =" + res.toString() )
                    hospitalizacijaAdapter.notifyDataSetChanged()
                }
            }
        }
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



    }

    override fun onResume() {
        super.onResume()
        sharedViewModel.pretraziPacijenta(SharedViewModel.HOSPITALIZOVAN, searchET.text.toString())


    }
}