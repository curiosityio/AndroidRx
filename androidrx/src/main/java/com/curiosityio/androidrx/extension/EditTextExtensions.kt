package com.curiosityio.androidrx.extension

import android.widget.EditText
import rx.Completable

fun EditText.verifyNotEmpty(errorMessage: String): Completable {
    return Completable.create { subscriber ->
        if (text.toString().isBlank()) {
            subscriber.onError(RuntimeException(errorMessage))
        } else {
            subscriber.onCompleted()
        }
    }
}