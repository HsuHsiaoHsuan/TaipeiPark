package funnybrain.hsu.idv.taipeipark.restful;

import funnybrain.hsu.idv.taipeipark.restful.model.WrappedData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RestApiService {
    String API_ENDPOINT = "http://data.taipei/";

    @GET("opendata/datalist/apiAccess")
    Observable<WrappedData> getData(@Query("scope") String scope, @Query("rid") String rid);
}
// http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=bf073841-c734-49bf-a97f-3757a6013812