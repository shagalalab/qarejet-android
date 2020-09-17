package com.shagalalab.core.usf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shagalalab.core.utils.data.Event
import com.shagalalab.core.utils.data.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
abstract class UsfViewModel<E : ViewEvent, R : ViewResult, S : ViewState, F : ViewEffect> : ViewModel() {
    private val tag = this.javaClass.simpleName
    private val eventEmitter: MutableStateFlow<E?> = MutableStateFlow(null)
    private val _viewState = MutableLiveData<S>()
    private val _viewEffect = MutableLiveData<Event<F>>()
    val viewState: LiveData<S> = _viewState
    val viewEffect: LiveData<Event<F>> = _viewEffect

    init {
        viewModelScope.launch {
            eventEmitter
                .filterNotNull()
                .onEach { println("$tag: eventEmitter, event: $it") }
                .eventToResult()
                .distinctUntilChanged()
                .onEach { println("$tag: eventEmitter, result: $it") }
                .collect { result ->
                    val state = convertResultToViewState(_viewState.value, result)
                    println("$tag, eventEmitter, new state = $state")
                    state?.let { _viewState.postValue(it) }

                    val effect = convertResultToViewEffect(result)
                    println("$tag, eventEmitter, new effect = $effect")
                    effect?.let { _viewEffect.postValue(Event(it)) }
                }
        }
    }

    fun processInput(event: E) {
        eventEmitter.value = event
    }

    protected abstract fun convertEventToResult(event: Flow<E>): Flow<Resource<R>>
    protected open fun convertResultToViewState(oldState: S?, result: Resource<R>): S? = null
    protected open fun convertResultToViewEffect(result: Resource<R>): F? = null

    private fun Flow<E>.eventToResult(): Flow<Resource<R>> {
        return convertEventToResult(this)
    }
}
