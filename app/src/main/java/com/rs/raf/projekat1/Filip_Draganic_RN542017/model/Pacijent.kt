package com.rs.raf.projekat1.Filip_Draganic_RN542017.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Pacijent(
    val id:UUID,
    val slika: String,
    val ime: String,
    val prezime: String,
    val datumPrijema: Date,
    val hospitalizovan: Boolean,
    val uCekaonici: Boolean,
    val stanje:String,
    val simptomi: String,
    val datumHospitalizacije:Date?,
    val datumOtpustanja:Date?

) : Parcelable