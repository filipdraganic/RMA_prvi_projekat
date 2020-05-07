package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent

class PacijentDiff : DiffUtil.ItemCallback<Pacijent>(){
    override fun areItemsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.ime == newItem.ime &&
                oldItem.prezime == newItem.prezime &&
                oldItem.hospitalizovan == newItem.hospitalizovan &&
                oldItem.uCekaonici == newItem.uCekaonici &&
                oldItem.datumHospitalizacije == newItem.datumHospitalizacije &&
                oldItem.datumOtpustanja == newItem.datumOtpustanja &&
                oldItem.datumPrijema == newItem.datumPrijema &&
                oldItem.slika == newItem.slika &&
                oldItem.stanje == newItem.stanje &&
                oldItem.simptomi == newItem.simptomi
    }

}