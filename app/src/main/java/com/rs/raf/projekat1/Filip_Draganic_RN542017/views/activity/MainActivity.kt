package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.ProfilFragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.viewpager.BottomPagerAdapter
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
        init()
    }


    private fun init(){
        noscrollBottomNavigation.adapter = BottomPagerAdapter(supportFragmentManager)



    }

    override fun onBackPressed(){
        super.onBackPressed()
        Timber.e("Nazad")

    }

    private fun initListeners(){
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_liste -> {
                    noscrollBottomNavigation.setCurrentItem(BottomPagerAdapter.LISTE,false)
                }

                R.id.navigation_stanje -> {
                    noscrollBottomNavigation.setCurrentItem(BottomPagerAdapter.STANJE,false)
                }

                R.id.navigation_unos -> {
                    noscrollBottomNavigation.setCurrentItem(BottomPagerAdapter.UNOS,false)
                }

                R.id.navigation_profil -> {
                    noscrollBottomNavigation.setCurrentItem(BottomPagerAdapter.PROFIL,false)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }


}
