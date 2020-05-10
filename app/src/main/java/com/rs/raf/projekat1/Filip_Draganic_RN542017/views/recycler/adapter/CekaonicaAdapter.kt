package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff.PacijentDiff
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.viewholders.CekaonicaViewHolder
import com.rsrafprojekat1.Filip_Draganic_RN542017.R

class CekaonicaAdapter (pacijentDiff: PacijentDiff, private val onZdravClicked: (Pacijent) -> Unit,
                        private val onHospitalizacijaClicked : (Pacijent) -> Unit) : ListAdapter<Pacijent, CekaonicaViewHolder>(pacijentDiff) {


    private val zdravoDugme: (Int) -> Unit = {
        if(it>=0){
            val pacijent = getItem(it)
            onZdravClicked.invoke(pacijent)
        }
    }

    private val hospitalizacijaDugme:(Int) -> Unit = {
        if(it >= 0){
            val pacijent = getItem(it)
            onHospitalizacijaClicked.invoke(pacijent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CekaonicaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.cekaonica_lista, parent,false)
        return CekaonicaViewHolder(containerView, zdravoDugme, hospitalizacijaDugme)
    }

    override fun onBindViewHolder(holder: CekaonicaViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)

    }


}