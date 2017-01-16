package com.curiosityio.androidrx.extension

import rx.Completable
import rx.Observable
import rx.Single
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action0
import rx.functions.Action1
import rx.schedulers.Schedulers

fun <T> Observable<T>.runOnBackgroundReportBackUIThread(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.runOnUIReportBackUIThread(): Observable<T> {
    return subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.subscribeRunBackgroundReportUI(onComplete: Action1<T>, onError: Action1<Throwable>, onCompleted: Action0? = null): Subscription {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onComplete, onError, onCompleted)
}

fun Completable.runOnBackgroundReportBackUIThread(): Completable {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun Completable.runOnUIReportBackUIThread(): Completable {
    return subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
}

fun Completable.subscribeRunBackgroundReportUI(onComplete: Action0, onError: Action1<Throwable>): Subscription {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onComplete, onError)
}

fun <T> Single<T>.runOnBackgroundReportBackUIThread(): Single<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.runOnUIReportBackUIThread(): Single<T> {
    return subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.subscribeRunBackgroundReportUI(onComplete: Action1<T>, onError: Action1<Throwable>): Subscription {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(onComplete, onError)
}