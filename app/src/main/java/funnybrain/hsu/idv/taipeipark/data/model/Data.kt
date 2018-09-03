package funnybrain.hsu.idv.taipeipark.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class Data {
    @SerializedName("offset")
    @Expose
    val offset: String? = null

    @SerializedName("limit")
    @Expose
    val limit: String? = null

    @SerializedName("count")
    @Expose
    val count: String? = null

    @SerializedName("sort")
    @Expose
    val sort: String? = null

    @SerializedName("results")
    @Expose
    val park: List<Park> = ArrayList()
}
