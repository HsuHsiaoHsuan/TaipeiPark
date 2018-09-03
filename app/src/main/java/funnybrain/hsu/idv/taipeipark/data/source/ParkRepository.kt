package funnybrain.hsu.idv.taipeipark.data.source

import funnybrain.hsu.idv.taipeipark.restful.DataRequest
import funnybrain.hsu.idv.taipeipark.restful.RestAPIBuilder
import funnybrain.hsu.idv.taipeipark.restful.RestApiService
import funnybrain.hsu.idv.taipeipark.data.model.WrappedData
import rx.functions.Action1

class ParkRepository private constructor(private val scope: String, private val rid: String) {
    private val api: RestApiService = RestAPIBuilder.buildRetrofitService()

    companion object {
        private var INSTANCE: ParkRepository? = null

        fun getInstance(scope: String, rid: String): ParkRepository =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: ParkRepository(scope, rid)
                }
    }

    fun getParks(callback: Action1<WrappedData>) {
        DataRequest.performAsyncRequest(api.getData(scope, rid), callback)
    }
}
