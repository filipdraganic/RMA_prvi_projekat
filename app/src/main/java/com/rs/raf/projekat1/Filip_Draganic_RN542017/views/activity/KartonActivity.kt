package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.HospitalizovaniFragment
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.activity_karton.*
import kotlinx.android.synthetic.main.activity_karton.imeET
import kotlinx.android.synthetic.main.activity_karton.prezimeET
import java.text.SimpleDateFormat
import java.util.*

class KartonActivity : AppCompatActivity(R.layout.activity_karton) {

    private lateinit var pacijent : Pacijent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pacijent = intent.getParcelableExtra(HospitalizovaniFragment.PACIJENT) ?: Pacijent(UUID.randomUUID(),"X AE A-12", "Musk", Date(), "Lud", "Lud",Date(),Date())

        init()
    }

    private fun init(){

        initListeners()

        imeET.setText(pacijent.ime)
        prezimeET.setText(pacijent.prezime)
        stanjePriPrijemuET.setText(pacijent.originalniSimptomi)
        trenutnoStanjeET.setText(pacijent.simptomi)
        datumPrijema.text = SimpleDateFormat("dd.mm.yyyy").format(pacijent.datumHospitalizacije)
    }

    private fun initListeners(){

        izmeniBtn.setOnClickListener {
            if(imeET.text.length < 3){
                Toast.makeText(this, "Ime prekratko", Toast.LENGTH_SHORT ).show()
            }
            else if(prezimeET.text.length < 3){
                Toast.makeText(this, "Prezime prekratko", Toast.LENGTH_SHORT ).show()
            }
            else if(stanjePriPrijemuET.text.toString().toLowerCase() != pacijent.originalniSimptomi.toLowerCase()){
                Toast.makeText(this, "Originalni simptomi se ne mogu menjati", Toast.LENGTH_SHORT ).show()
            }
            else if(trenutnoStanjeET.text.length < 3){
                Toast.makeText(this, "Sigurno mu jos nesto fali", Toast.LENGTH_SHORT ).show()
            }
            else{
                pacijent.simptomi = trenutnoStanjeET.text.toString()
                pacijent.prezime =  prezimeET.text.toString()
                pacijent.ime = imeET.text.toString()

                val returnIntent = Intent()
                returnIntent.putExtra(HospitalizovaniFragment.PACIJENT, pacijent)
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }

        }

        odustaniBtn.setOnClickListener{
            val returnIntent = Intent()
            setResult(Activity.RESULT_CANCELED, returnIntent)
            finish()
        }

    }




}
