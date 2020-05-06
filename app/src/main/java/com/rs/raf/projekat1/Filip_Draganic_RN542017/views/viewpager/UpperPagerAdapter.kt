package com.rs.raf.projekat1.Filip_Draganic_RN542017.views.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.CekaonicaFragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.HospitalizovaniFragment
import com.rs.raf.projekat1.Filip_Draganic_RN542017.views.fragments.OtpusteniFragment

class UpperPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        private const val COUNT = 3
        const val CEKAONICA = 0
        const val HOSPITALIZOVANI = 1
        const val OTPUSTENI = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            CEKAONICA -> CekaonicaFragment()
            HOSPITALIZOVANI -> HospitalizovaniFragment()
            else -> OtpusteniFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            CEKAONICA -> "CEKAONICA"
            HOSPITALIZOVANI -> "HOSPITALIZOVANI"
            else -> "OTPUSTENI"
        }
    }
}