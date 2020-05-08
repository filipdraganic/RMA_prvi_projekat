package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel.SharedViewModel
import com.rsrafprojekat1.Filip_Draganic_RN542017.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val password = sharedPreferences.getBoolean("loggedin", false) ?: false

        val intent = if(!password) {
            Intent(this, LoginActivity::class.java)
        } else{
            Intent(this, MainActivity::class.java)
        }

        startActivity(intent)
        finish()
    }
}
