package funnybrain.hsu.idv.taipeipark.restful.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Park {
    @SerializedName("_id")
    @Expose
    val _id: String? = null

    @SerializedName("ParkName") // 公園名稱
    @Expose
    val parkName: String? = null

    @SerializedName("Name") // 照片名稱
    @Expose
    val picName: String? = null

    @SerializedName("YearBuilt") // 建造日期
    @Expose
    val year: String? = null

    @SerializedName("OpenTime") // 開方時間
    @Expose
    val open: String? = null

    @SerializedName("Image") // 圖片 URL
    @Expose
    val image: String? = null

    @SerializedName("Introduction") // 介紹
    @Expose
    val intro: String? = null
}
