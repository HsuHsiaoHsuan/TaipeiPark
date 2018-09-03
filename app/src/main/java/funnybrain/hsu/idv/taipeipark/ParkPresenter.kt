package funnybrain.hsu.idv.taipeipark

import funnybrain.hsu.idv.taipeipark.restful.model.WrappedData
import rx.functions.Action1

class ParkPresenter(private val mParkRepository: ParkRepository, private val mParkView: ParkContract.View) : ParkContract.Presenter {
    private val test = Action1<WrappedData> { wrappedData -> mParkView.showPark(wrappedData.result!!.park) }

    init {
        mParkView.setPresenter(this)
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
