package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.viewholders.HospitalizovanViewHolder
import com.rsrafprojekat1.Filip_Draganic_RN542017.R

class HospitalizacijaAdapter (pacijentDiff: PacijentDiff, private val onKartonClicked: (Pacijent) -> Unit,
                                private val onOtpustiClicked: (Pacijent) -> Unit) : ListAdapter<Pacijent, HospitalizovanViewHolder>(pacijentDiff) {

    private val kartonDugme: (Int) -> Unit = {
        if(it >= 0){
            val pacijent = getItem(it)
            onKartonClicked.invoke(pacijent)
        }
    }

    private val otpustiDugme: (Int) -> Unit = {
        if(it >= 0){
            val pacijent = getItem(it)
            onOtpustiClicked.invoke(pacijent)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalizovanViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.hospitalizacija_lista, parent, false)
        return HospitalizovanViewHolder(containerView, kartonDugme, otpustiDugme)


    }

    override fun onBindViewHolder(holder: HospitalizovanViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}