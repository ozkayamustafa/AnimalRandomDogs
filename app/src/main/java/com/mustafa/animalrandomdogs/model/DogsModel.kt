package com.mustafa.animalrandomdogs.model

import com.google.gson.annotations.SerializedName

data class DogsModel(
    @SerializedName("id") var id     : String? = null,
    @SerializedName("url") var url    : String? = null,
    @SerializedName("width") var width  : Int?    = null,
    @SerializedName("height") var height : Int?    = null
)