package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity.LoginActivity
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity.MainActivity
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_profil.*

class ProfilFragment : Fragment(R.layout.fragment_profil){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val sharedPreferences = activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)

        val ime = sharedPreferences?.getString("ime", "Nema ime")
        val prezime = sharedPreferences?.getString("prezime", "Nema prezime")
        val bolnica = sharedPreferences?.getString("bolnica", "Nema bolnicu")

        imeTV.text = ime
        prezimeTV.text = prezime
        bolnicaTV.text = bolnica

        initListeners()


    }

    private fun initListeners( ){

        izmeniBtn.setOnClickListener {
            izmeniBtn.visibility = View.GONE
            odjavaBtn.visibility = View.GONE

            saveBtn.visibility = View.VISIBLE
            odustaniBtn.visibility = View.VISIBLE

            imeET.setText(imeTV.text)
            prezimeET.setText(prezimeTV.text)
            bolnicaET.setText(bolnicaTV.text)

            imeTV.visibility = View.GONE
            prezimeTV.visibility = View.GONE
            bolnicaTV.visibility = View.GONE

            imeET.visibility = View.VISIBLE
            prezimeET.visibility = View.VISIBLE
            bolnicaET.visibility = View.VISIBLE


        }

        saveBtn.setOnClickListener {
            val sharedPreferences = activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            if (editor != null) {
                editor.putString("ime", imeET.text.toString())
                editor.putString("prezime", prezimeET.text.toString())
                editor.putString("bolnica", bolnicaET.text.toString())


                editor.apply()
            }

            imeTV.text = imeET.text.toString()
            prezimeTV.text = prezimeET.text.toString()
            bolnicaTV.text = bolnicaET.text.toString()

            izmeniBtn.visibility = View.VISIBLE
            odjavaBtn.visibility = View.VISIBLE

            saveBtn.visibility = View.GONE
            odustaniBtn.visibility = View.GONE

            imeTV.visibility = View.VISIBLE
            prezimeTV.visibility = View.VISIBLE
            bolnicaTV.visibility = View.VISIBLE

            imeET.visibility = View.GONE
            prezimeET.visibility = View.GONE
            bolnicaET.visibility = View.GONE


        }

        odustaniBtn.setOnClickListener {
            izmeniBtn.visibility = View.VISIBLE
            odjavaBtn.visibility = View.VISIBLE

            saveBtn.visibility = View.GONE
            odustaniBtn.visibility = View.GONE

            imeTV.visibility = View.VISIBLE
            prezimeTV.visibility = View.VISIBLE
            bolnicaTV.visibility = View.VISIBLE

            imeET.visibility = View.GONE
            prezimeET.visibility = View.GONE
            bolnicaET.visibility = View.GONE
        }

        odjavaBtn.setOnClickListener {
            val sharedPreferences = activity?.getSharedPreferences(activity?.packageName, Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            if (editor != null){
                editor.putBoolean("loggedin", false)
                editor.apply()

                val intent = Intent(activity , LoginActivity::class.java)

                startActivity(intent)

                activity?.finish()

            }
        }

    }

}