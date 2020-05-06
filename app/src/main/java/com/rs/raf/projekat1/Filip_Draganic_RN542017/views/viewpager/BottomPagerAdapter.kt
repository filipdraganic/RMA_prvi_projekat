package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.ListeFragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.ProfilFragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.StanjeFragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.UnosFragment

class BottomPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object{
        private const val COUNT = 4
        const val STANJE = 0
        const val UNOS = 1
        const val LISTE = 2
        const val PROFIL = 3
    }


    override fun getItem(position: Int): Fragment {
        return when(position){
            STANJE -> StanjeFragment()
            UNOS -> UnosFragment()
            LISTE -> ListeFragment()
            else -> ProfilFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            STANJE -> "Stanje"
            UNOS -> "Unos"
            LISTE -> "Liste"
            else -> "Profil"
        }
    }

}