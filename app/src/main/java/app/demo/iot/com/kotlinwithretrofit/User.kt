package app.demo.iot.com.kotlinwithretrofit

import com.google.gson.annotations.SerializedName

/**
 * Created by muhammed on 2/14/2018.
 */
data class User(
        @SerializedName("userId") val userId: Int,
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
)
