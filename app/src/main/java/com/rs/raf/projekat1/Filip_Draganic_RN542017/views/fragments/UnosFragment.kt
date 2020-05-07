package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_unos.*
import java.text.SimpleDateFormat
import java.util.*

class UnosFragment : Fragment(R.layout.fragment_unos){

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initListeners()
    }

    private fun initListeners(){

        dodajBtn.setOnClickListener{

            if (imeET.text.toString().length < 3) {
                Toast.makeText(activity, "Prekratko ime", Toast.LENGTH_SHORT).show()
            }
            else if (prezimeET.text.toString().length < 3) {
                Toast.makeText(activity, "Prekratko prezime", Toast.LENGTH_SHORT).show()
            }
            else if (simptomiET.text.toString().length < 3) {
                Toast.makeText(activity, "Sigurno mu jos nesto fali", Toast.LENGTH_SHORT).show()

            }
            else {

                sharedViewModel.dodajPacijenta(
                    Pacijent(
                        UUID.randomUUID(), "",
                        imeET.text.toString(), prezimeET.text.toString(), Date(), false,
                        true, 0, simptomiET.text.toString(), null, null
                    ), 0
                )


                imeET.setText("")
                prezimeET.setText("")
                simptomiET.setText("")

            }
        }

    }
}