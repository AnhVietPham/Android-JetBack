package com.example.androidjetback

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
class Money(val amount: BigDecimal = BigDecimal(0)) : Parcelable