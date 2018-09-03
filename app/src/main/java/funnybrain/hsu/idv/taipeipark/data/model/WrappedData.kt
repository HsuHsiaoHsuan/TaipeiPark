package funnybrain.hsu.idv.taipeipark.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WrappedData {
    @SerializedName("result")
    @Expose
    val result: Data? = null
}
