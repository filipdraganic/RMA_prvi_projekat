package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners(){
        val sharedpreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val ime = sharedpreferences.getString("ime","failed")
        val prezime = sharedpreferences.getString("prezime", "failed")
        val bolnica = sharedpreferences.getString("bolnica", "failed")



        imeTV.text = ime
        prezimeTV.text = prezime
        bolnicaTV.text = bolnica

        logoutBtn.setOnClickListener{
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putBoolean("loggedin", false)

            editor.apply()
        }




    }
}
