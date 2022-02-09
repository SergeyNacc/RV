package nacc.sergey.rv.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UserModel(
    val firstName: String,
    val lastName: String
) : Parcelable

