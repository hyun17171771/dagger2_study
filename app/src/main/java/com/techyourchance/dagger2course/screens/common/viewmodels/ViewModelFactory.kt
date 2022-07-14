package com.techyourchance.dagger2course.screens.common.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

/**
 * Map<Class<out ViewModel>, Provider<ViewModel>>
 *     value가 일반 viewmodel인 이유는 viewmodel module의 반환값이 viewmodel이기 때문
 *
 * @JvmSuppressWildcards -> 코틀린 컴파일러는 제네릭을 기본적으로 List<String>을 List<? extends String> 형태로 변환한다
 * 이 주석은 이런 형태의 자동변환을 방지한다
 */
class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val provider = providers[modelClass]

        /**
         * provider가 null 이라는 것은 뷰모델 모듈에 해당 뷰모델을 넣지 않았다는 것이고 이것은 개발자의 실수다
          그러므로 null일 때 RuntimeException을 내서 빨리 찾아낼 수 있게 하는 것
         */
        return provider?.get() as T ?: throw RuntimeException("unsupported viewmodel type: $modelClass")
    }

}