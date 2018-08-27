package funnybrain.hsu.idv.taipeipark

import funnybrain.hsu.idv.taipeipark.restful.model.Park

interface ParkContract {
    interface View : BaseView<Presenter> {
        fun showProgress(show: Boolean)

        fun showPark(parks: List<Park>)
    }

    interface Presenter : BasePresenter {
        fun loadTask(forceUpdate: Boolean)
    }
}
