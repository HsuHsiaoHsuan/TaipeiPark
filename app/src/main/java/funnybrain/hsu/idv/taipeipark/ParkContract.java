package funnybrain.hsu.idv.taipeipark;

import java.util.List;

import funnybrain.hsu.idv.taipeipark.restful.model.Park;

public interface ParkContract {
    interface View extends BaseView<Presenter> {
        void showProgress(boolean show);

        void showPark(List<Park> parks);
    }

    interface Presenter extends BasePresenter {
        void loadTask(boolean forceUpdate);
    }
}
