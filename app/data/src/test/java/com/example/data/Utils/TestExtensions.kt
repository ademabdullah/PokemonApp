package com.example.data.Utils

import junit.framework.TestCase.fail

class TestExtensions {

    fun<T> Result <T>.expectSuccess(assertions:(T) -> Unit) {
        this.onSuccess { assertions(it) }
            .onFailure { fail("Expected success but got failure: ${it.message}")}
    }

    fun<T>Result<T>.expectFailure(assertions: (Throwable) -> Unit) {
        this.onFailure { assertions(it)}
            .onSuccess { fail("Expected failure but got success: {$it}")}

    }

}