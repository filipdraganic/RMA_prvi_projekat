package com.rs.raf.projekat1.Filip_Draganic_RN542017.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rs.raf.projekat1.Filip_Draganic_RN542017.model.Pacijent
import timber.log.Timber
import java.util.*

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

    private val toShowData : MutableLiveData<List<Pacijent>> = MutableLiveData()


    fun getCekaonicaData() : MutableLiveData<List<Pacijent>> {
        return cekaonicaData
    }
    fun getHospitalizovaniData() : MutableLiveData<List<Pacijent>> {
        return hospitalizovaniData
    }
    fun getOtpusteniData() : MutableLiveData<List<Pacijent>> {
        return otpusteniData
    }


    fun testPacijenti(){
        val imena = listOf<String>("Finn", "Colton", "Macey", "Ori", "Slade", "Noelle", "Erich")
        val prezimena = listOf<String>("Martinez", "Curtis", "Ruiz", "Calderon","Rollins", "Cameron", "Espinoza", "Dyer")
        val simptomi = listOf<String>("Abdominal Pain of Absolutely No Significance -  as in why come to the ER type of pain. ",
            "Acute Exacerbation of Chronic Nonsense -  self explanatory. ",
            "Arrestogenic Shock -  sudden life threatening illness caused by getting arrested.",
            "Biscuit Poisoning -  what morbidly obese patients have.",
            "Chandelier Sign - jumping off the bed to belly palpation,  seen with extreme pain.",
            "Crapacardia -  a bad EKG that needs to be repeated",
            "Cyberchondria -  worrying about all the worst possibilities after reading the internet. ",
            "Dead Shovel -  a patient who has a heart attack shoveling snow.",
            "Dizziness of No Possible Cause:  a top 10 ER diagnosis. ",
            "GonoherpasyphilAIDS - has all the STDs from sleeping with the entire football team.",
            "I sign -  as in the sound of pain in Spanish (e.g. aye...aye...AYE...aye).",
            "Insurance Pain -  pain that presents when insurance settlements are involved. ",
            "Polybabydaddia -  a woman who comes to the ER with multiple kids from different daddies.",
            "Ridiculitis - because every symptom needs respect. ")
        val bool = listOf<Boolean>(true, false)

        val rnds = (0..2).random()
        val simptom = simptomi[(0 until simptomi.size).random()]

        val bulvrednost = bool[(0..1).random()]
        dodajPacijenta(Pacijent(UUID.randomUUID(),imena[(0 until imena.size).random()],
            prezimena[(0 until prezimena.size).random()], Date() , simptom, simptom,
            null, null ) ,0)


    }


    fun dodajPacijenta(pacijent: Pacijent, stanje: Int){
        Timber.e("%s ,stanje = %s", pacijent.toString(), stanje)
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



    fun premestiPacijenta(pacijent: Pacijent, stanje: Int, uStanje: Int){

        when(stanje){
            CEKAONICA->{
                when(uStanje){
                    HOSPITALIZOVAN -> {
                        cekaonicaLista.remove(pacijent)
                        hospitalizovaniLista.add(pacijent)
                    }
                    OTPUSTEN ->{
                        cekaonicaLista.remove(pacijent)
                        otpusteniLista.add(pacijent)
                    }
                    else -> {
                        Timber.e("Greska u Shared View Model 1")
                    }
                }
            }
            HOSPITALIZOVAN -> {
                hospitalizovaniLista.remove(pacijent)
                otpusteniLista.add(pacijent)
            }
            else -> {
                Timber.e("Greska u Shared View Model 2")

            }
        }
    }

    fun pretraziPacijenta(lista: Int, string: String): MutableLiveData<List<Pacijent>> {

        val tempLista : MutableList<Pacijent> = mutableListOf()

        when(lista){
            CEKAONICA -> {
                if (string == "") return cekaonicaData
                cekaonicaLista.forEach {if (it.ime.contains(string) || it.prezime.contains(string)) tempLista.add(it) }
            }
            HOSPITALIZOVAN -> {
                if (string == "") return hospitalizovaniData
                hospitalizovaniLista.forEach {if (it.ime.contains(string) || it.prezime.contains(string)) tempLista.add(it) }
            }
            else -> {
                if (string == "") return otpusteniData
                otpusteniLista.forEach {if (it.ime.contains(string) || it.prezime.contains(string)) tempLista.add(it) }
            }
        }
        toShowData.value = tempLista
        return toShowData

    }





}