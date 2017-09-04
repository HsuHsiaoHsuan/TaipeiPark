package funnybrain.hsu.idv.taipeipark;

import android.util.Log;

import funnybrain.hsu.idv.taipeipark.restful.DataRequest;
import funnybrain.hsu.idv.taipeipark.restful.RestApiService;
import funnybrain.hsu.idv.taipeipark.restful.RestAPIBuilder;
import funnybrain.hsu.idv.taipeipark.restful.model.WrappedData;
import rx.functions.Action1;

public class ParkRepository {

    private static ParkRepository INSTANCE = null;

    private final String scope;
    private final String rid;
    private final RestApiService api;

    private ParkRepository(String scope, String rid) {
        this.scope = scope;
        this.rid = rid;
        api = RestAPIBuilder.buildRetrofitService();
    }

    public static ParkRepository getInstance(String scope, String rid) {
        if (INSTANCE == null) {
            INSTANCE = new ParkRepository(scope, rid);
        }

        return INSTANCE;
    }

    public void getParks(Action1<WrappedData> callback) {
        Log.e("FREEMAN", "scope: " + scope);
        Log.e("FREEMAN", "rid: " + rid);
        DataRequest.performAsyncRequest(api.getData(scope, rid), callback);
    }
}