package com.rs.raf.projekat1.Filip_Draganic_RN542017.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Pacijent(
    val id:UUID,
    val ime: String,
    val prezime: String,
    val datumPrijema: Date,
    val simptomi: String,
    val originalniSimptomi: String,
    val datumHospitalizacije:Date?,
    val datumOtpustanja:Date?

) : Parcelable