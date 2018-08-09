package com.launchmode.artus.runlooptest.model

import android.os.Parcel
import android.os.Parcelable

class RssEntry() : Parcelable {

    lateinit var title: String
    lateinit var description: String
    lateinit var date: String

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString(), parcel.readString())

    constructor(title: String, description: String, date: String) : this() {
        this.title = title
        this.description = description
        this.date = date
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<RssEntry> {
            override fun createFromParcel(parcel: Parcel): RssEntry {
                return RssEntry(parcel)
            }

            override fun newArray(size: Int): Array<RssEntry?> {
                return arrayOfNulls(size)
            }
        }
    }

}