package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.viewpager.UpperPagerAdapter
import com.rsrafprojekat1.Filip_Draganic_RN542017.R
import kotlinx.android.synthetic.main.fragment_liste.*

class ListeFragment : Fragment(R.layout.fragment_liste){



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initTabs()
    }

    private fun initTabs(){
        tabViewPager.adapter = UpperPagerAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(tabViewPager)
    }
}