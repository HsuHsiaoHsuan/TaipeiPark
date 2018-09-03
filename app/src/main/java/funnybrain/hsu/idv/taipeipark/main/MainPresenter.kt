package funnybrain.hsu.idv.taipeipark.main

import funnybrain.hsu.idv.taipeipark.data.source.ParkRepository
import funnybrain.hsu.idv.taipeipark.data.model.WrappedData
import rx.functions.Action1

class MainPresenter(private val mParkRepository: ParkRepository, private val mMainView: MainContract.View) : MainContract.Presenter {
    private val test = Action1<WrappedData> { wrappedData -> mMainView.showPark(wrappedData.result!!.park) }

    init {
        mMainView.setPresenter(this)
    }

    override fun start() {
        loadTask(false)
    }

    override fun loadTask(forceUpdate: Boolean) {
        if (forceUpdate) {
            mParkRepository.getParks(test)
        }
    }
}
