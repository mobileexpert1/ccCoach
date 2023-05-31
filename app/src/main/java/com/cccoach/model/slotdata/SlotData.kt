package com.cccoach.model.slotdata

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SlotData(

    @field:SerializedName("createdAt")
    val createdAt: String? = "",

    @field:SerializedName("stateId")
    val stateId: Int? = 0,

    @field:SerializedName("__v")
    val V: Int? = 0,

    @field:SerializedName("fromTime")
    val fromTime: String? = "",
    @field:SerializedName("date")
    val date: String? = "",

    @field:SerializedName("bookingStatus")
    var bookingStatus: Int? = 0,

    @field:SerializedName("uptoTime")
    val uptoTime: String? = "",

    @field:SerializedName("typeId")
    val typeId: Int? = 0,

    @field:SerializedName("_id")
    val id: String? = "",

    @field:SerializedName("userId")
    val userId: String? = "",

    @field:SerializedName("updatedAt")
    val updatedAt: String? = "",

    var isChecked: Boolean = false,

    ) : Parcelable