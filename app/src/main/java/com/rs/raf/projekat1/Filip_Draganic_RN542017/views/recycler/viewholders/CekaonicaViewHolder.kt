package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.cekaonica_lista.*
import kotlinx.android.synthetic.main.fragment_stanje.*
import kotlinx.android.synthetic.main.fragment_unos.*

class CekaonicaViewHolder(override val containerView: View, onZdravClicked: (Int) -> Unit,
                            onHospitalizacijaClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    init {
        zdravBtn.setOnClickListener{
            if(adapterPosition != RecyclerView.NO_POSITION)
                onZdravClicked.invoke(adapterPosition)
        }
        hospitalizacijaBtn.setOnClickListener {
            if(adapterPosition != RecyclerView.NO_POSITION)
                onHospitalizacijaClicked.invoke(adapterPosition)
        }
    }

    fun bind(pacijent: Pacijent){
        imeTV.text = pacijent.ime
        prezimeTV.text = pacijent.prezime
        simptomiTV.text = pacijent.simptomi
    }

}