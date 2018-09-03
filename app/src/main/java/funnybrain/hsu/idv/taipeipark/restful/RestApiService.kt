package funnybrain.hsu.idv.taipeipark.restful

import funnybrain.hsu.idv.taipeipark.data.model.WrappedData
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface RestApiService {

    @GET("opendata/datalist/apiAccess")
    fun getData(@Query("scope") scope: String, @Query("rid") rid: String): Observable<WrappedData>

    companion object { // https://kotlinlang.org/docs/reference/object-declarations.html#companion-objects
        val API_ENDPOINT = "http://data.taipei/"
    }
}
// http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=bf073841-c734-49bf-a97f-3757a6013812