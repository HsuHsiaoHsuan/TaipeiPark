package funnybrain.hsu.idv.taipeipark.restful

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestAPIBuilder {
    fun buildRetrofitService(): RestApiService {
        val retrofit = Retrofit.Builder()
                .baseUrl(RestApiService.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()

        return retrofit.create(RestApiService::class.java)
    }
}
