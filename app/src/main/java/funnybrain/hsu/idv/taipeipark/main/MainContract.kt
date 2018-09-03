package funnybrain.hsu.idv.taipeipark.main

import funnybrain.hsu.idv.taipeipark.BasePresenter
import funnybrain.hsu.idv.taipeipark.BaseView
import funnybrain.hsu.idv.taipeipark.data.model.Park

interface MainContract {
    interface View : BaseView<Presenter> {
        fun showProgress(show: Boolean)

        fun showPark(parks: List<Park>)
    }

    interface Presenter : BasePresenter {
        fun loadTask(forceUpdate: Boolean)
    }
}
