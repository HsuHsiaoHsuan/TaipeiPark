package funnybrain.hsu.idv.taipeipark;

import android.support.annotation.NonNull;
import android.util.Log;

import funnybrain.hsu.idv.taipeipark.restful.model.WrappedData;
import rx.functions.Action1;

public class ParkPresenter implements ParkContract.Presenter {

    private final ParkContract.View mParkView;
    private final ParkRepository mParkRepository;
    private Action1<WrappedData> test = new Action1<WrappedData>() {
        @Override
        public void call(WrappedData wrappedData) {
            mParkView.showPark(wrappedData.getResult().getPark());
        }
    };

    public ParkPresenter(@NonNull ParkRepository repository, @NonNull ParkContract.View parkView) {
        mParkRepository = repository;
        mParkView = parkView;
        mParkView.setPresenter(this);
    }

    @Override
    public void start() {
        loadTask(false);
    }

    @Override
    public void loadTask(boolean update) {
        if (update) {
            mParkRepository.getParks(test);
        }
    }
}
