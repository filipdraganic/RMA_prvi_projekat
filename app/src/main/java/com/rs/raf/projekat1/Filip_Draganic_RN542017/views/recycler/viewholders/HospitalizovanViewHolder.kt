package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.hospitalizacija_lista.*

class HospitalizovanViewHolder (override val containerView :View, onKartonClicked : (Int) -> Unit,
                                onOtpustiClicked : (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        kartonBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onKartonClicked.invoke(adapterPosition)
            }
        }
        otpustBtn.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onOtpustiClicked.invoke(adapterPosition)
            }
        }

    }

    fun bind(pacijent: Pacijent){
        imeTV.text = pacijent.ime
        prezimeTV.text = pacijent.prezime
    }

}

