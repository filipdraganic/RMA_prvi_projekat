package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.recycler.viewholders

import android.view.View
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.hospitalizacija_lista.*
import kotlinx.android.synthetic.main.hospitalizacija_lista.imeTV
import kotlinx.android.synthetic.main.hospitalizacija_lista.prezimeTV
import kotlinx.android.synthetic.main.otpusteni_lista.*
import java.text.SimpleDateFormat

class OtpustenViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    fun bind(pacijent: Pacijent){
        imeTV.text = pacijent.ime
        prezimeTV.text = pacijent.prezime
        datumOtpustaTV.text = "Otpusten: " + SimpleDateFormat("dd.MM.yyyy").format(pacijent.datumOtpustanja)
    }


}