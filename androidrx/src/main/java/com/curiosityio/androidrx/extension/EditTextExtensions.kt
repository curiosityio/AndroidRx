package com.curiosityio.androidrx.extension

import android.widget.EditText
import com.curiosityio.androidrx.R
import rx.Completable

fun EditText.verifyNotEmpty(errorMessage: String): Completable {
    return Completable.create { subscriber ->
        if (text.toString().isBlank()) {
            error = errorMessage
            subscriber.onError(RuntimeException(errorMessage))
        } else {
            subscriber.onCompleted()
        }
    }
}

fun EditText.verifyEmail(): Completable {
    return Completable.create { subscriber ->
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            subscriber.onCompleted()
        } else {
            error = context.getString(R.string.enter_email_address)
            subscriber.onError(RuntimeException(error!!.toString()))
        }
    }
}