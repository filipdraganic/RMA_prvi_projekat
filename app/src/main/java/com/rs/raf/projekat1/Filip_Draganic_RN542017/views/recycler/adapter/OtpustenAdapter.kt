package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.viewholders.OtpustenViewHolder
import com.rsrafprojekat1.Filip_Draganic_RN542017.R

class OtpustenAdapter (pacijentDiff: PacijentDiff) : ListAdapter<Pacijent, OtpustenViewHolder>(pacijentDiff){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtpustenViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.otpusteni_lista, parent, false)
        return OtpustenViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: OtpustenViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}