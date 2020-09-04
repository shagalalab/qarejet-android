package com.shagalalab.core.usf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shagalalab.core.utils.data.Event
import com.shagalalab.core.utils.data.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
abstract class UsfViewModel<E : ViewEvent, R : ViewResult, S : ViewState, F : ViewEffect> : ViewModel() {
    private val eventEmitter: MutableStateFlow<E?> = MutableStateFlow(null)

    private val _viewState = MutableLiveData<S>()
    private val _viewEffect = MutableLiveData<Event<F>>()
    val viewState: LiveData<S> = _viewState
    val viewEffect: LiveData<Event<F>> = _viewEffect

    init {
        viewModelScope.launch {
            eventEmitter
                .filterNotNull()
                .onEach { println("UsfViewModel: eventEmitter, event: $it") }
                .eventToResult()
                .onEach { println("UsfViewModel: eventEmitter, result: $it") }
                .collect { result ->
                    val state = convertResultToViewState(result)
                    _viewState.postValue(state)

                    val effect = convertResultToViewEffect(result)
                    effect?.let { _viewEffect.postValue(Event(it)) }
                }
        }
    }

    fun processInput(event: E) {
        eventEmitter.value = event
    }

    protected abstract fun convertEventToResult(e: E): Resource<R>
    protected abstract fun convertResultToViewState(r: Resource<R>): S
    protected abstract fun convertResultToViewEffect(r: Resource<R>): F?

    private fun Flow<E>.eventToResult(): Flow<Resource<R>> {
        return map { convertEventToResult(it) }
    }
}
