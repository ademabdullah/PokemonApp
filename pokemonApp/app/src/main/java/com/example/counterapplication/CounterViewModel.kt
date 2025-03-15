package com.example.counterapplication

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(private val repository: CounterRepository) : ViewModel() {
    private val _count = mutableStateOf(0)

    val count: MutableState<Int> = _count

    fun increment() {}

    fun decrement() {}
}
