package funnybrain.hsu.idv.taipeipark.restful

import android.util.Log

import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

object DataRequest {
    private val TAG = DataRequest.javaClass.simpleName

    private val mOnError = Action1<Throwable> { throwable ->
        Log.e(TAG, throwable.message)
        throwable.printStackTrace()
    }

    fun <T> performAsyncRequest(observable: Observable<T>, onAction: Action1<in T>): Subscription {
        return performAsyncRequest(observable, onAction, mOnError)
    }

    private fun <T> performAsyncRequest(observable: Observable<T>, onAction: Action1<in T>, onError: Action1<Throwable>): Subscription {
        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onAction, onError)
    }
}
