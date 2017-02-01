package com.curiosityio.androidrx.extension

import rx.Completable
import rx.Observable
import rx.Single
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action0
import rx.functions.Action1
import rx.schedulers.Schedulers

// io() is good for network calls, file system calls, database calls, service calls. Not CPU intensive calls. 
// computation() is a more rare use. Use it only for CPU intensive tasks.

// subscribeOn() tells the top of the Observable chain to run on ___ thread and all the way down the chain until an observeOn() is encountered. You can only have 1 subscribeOn(). Only the top-most one is used. Others below is are ignored.
// observeOn() tells the code all below it to run on ___ thread all the way down the chain until another observeOn() is encountered. You can have many observeOn() to keep changing what threads run on what.
fun <T> Observable<T>.runFollowingOnBackgroundThread(): Observable<T> {
    return observeOn(Schedulers.io())
}

fun <T> Observable<T>.runFollowingCpuIntensiveTasksOnBackgroundThread(): Observable<T> {
    return observeOn(Schedulers.computation())
}

fun <T> Observable<T>.runFollowingOnUIThread(): Observable<T> {
    return observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.operateOnBackgroundThread(): Observable<T> {
    return subscribeOn(Schedulers.io())
}

fun <T> Observable<T>.operateOnCPUIntensiveBackgroundThread(): Observable<T> {
    return subscribeOn(Schedulers.computation())
}

fun <T> Observable<T>.operateOnUIThread(): Observable<T> {
    return subscribeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.runFollowingOnBackgroundThread(): Single<T> {
    return observeOn(Schedulers.io())
}

fun <T> Single<T>.runFollowingCpuIntensiveTasksOnBackgroundThread(): Single<T> {
    return observeOn(Schedulers.computation())
}

fun <T> Single<T>.runFollowingOnUIThread(): Single<T> {
    return observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.operateOnBackgroundThread(): Single<T> {
    return subscribeOn(Schedulers.io())
}

fun <T> Single<T>.operateOnCPUIntensiveBackgroundThread(): Single<T> {
    return subscribeOn(Schedulers.computation())
}

fun <T> Single<T>.operateOnUIThread(): Single<T> {
    return subscribeOn(AndroidSchedulers.mainThread())
}

fun Completable.runFollowingOnBackgroundThread(): Completable {
    return observeOn(Schedulers.io())
}

fun Completable.runFollowingCpuIntensiveTasksOnBackgroundThread(): Completable {
    return observeOn(Schedulers.computation())
}

fun Completable.runFollowingOnUIThread(): Completable {
    return observeOn(AndroidSchedulers.mainThread())
}

fun Completable.operateOnBackgroundThread(): Completable {
    return subscribeOn(Schedulers.io())
}

fun Completable.operateOnCPUIntensiveBackgroundThread(): Completable {
    return subscribeOn(Schedulers.computation())
}

fun Completable.operateOnUIThread(): Completable {
    return subscribeOn(AndroidSchedulers.mainThread())
}


