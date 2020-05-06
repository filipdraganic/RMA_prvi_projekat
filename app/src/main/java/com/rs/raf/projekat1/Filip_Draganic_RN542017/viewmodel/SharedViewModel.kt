package com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent

class SharedViewModel : ViewModel(){

    companion object{
        const val CEKAONICA = 0
        const val HOSPITALIZOVAN = 1
        const val OTPUSTEN = 2
    }

    private val cekaonicaLista : MutableList<Pacijent> = mutableListOf()
    private val hospitalizovaniLista : MutableList<Pacijent> = mutableListOf()
    private val otpusteniLista : MutableList<Pacijent> = mutableListOf()


    private val cekaonicaData : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val hospitalizovaniData : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val otpusteniData : MutableLiveData<List<Pacijent>> = MutableLiveData()


    fun getCekaonicaData() : MutableLiveData<List<Pacijent>> {
        return cekaonicaData
    }
    fun getHospitalizovaniData() : MutableLiveData<List<Pacijent>> {
        return hospitalizovaniData
    }
    fun getOtpusteniData() : MutableLiveData<List<Pacijent>> {
        return otpusteniData
    }

    fun dodajPacijenta(pacijent: Pacijent, stanje : Int){

        when(stanje){
            CEKAONICA -> {
                cekaonicaLista.add(pacijent)
                cekaonicaData.value = cekaonicaLista
            }
            HOSPITALIZOVAN ->{
                hospitalizovaniLista.add(pacijent)
                hospitalizovaniData.value = hospitalizovaniLista
            }
            else ->{
                otpusteniLista.add(pacijent)
                otpusteniData.value = otpusteniLista
            }
        }


    }





}