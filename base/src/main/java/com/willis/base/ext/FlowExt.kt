package com.willis.base.ext

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * description: Flow 扩展函数
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */

val mStateInScope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())

inline fun <T> Flow<T>.collectWhenStarted(
    lifecycleScope: LifecycleCoroutineScope,
    crossinline action: suspend (T) -> Unit
) = lifecycleScope.launchWhenStarted {
    collect {
        action.invoke(it)
    }
}

inline fun <T> Flow<T>.collectWhenResumed(
    lifecycleScope: LifecycleCoroutineScope,
    crossinline action: suspend (T) -> Unit
) = lifecycleScope.launchWhenResumed {
    collect {
        action.invoke(it)
    }
}

inline fun <T, R> StateFlow<T>.mapToStateFlow(crossinline transform: (value: T) -> R): StateFlow<R?> {
    return mapToStateFlow(transform, null)
}

inline fun <T, R> StateFlow<T>.mapToStateFlow(crossinline transform: (value: T) -> R, initialValue: R): StateFlow<R> {
    return map { transform(it) }.stateIn(mStateInScope, SharingStarted.Eagerly, initialValue)
}