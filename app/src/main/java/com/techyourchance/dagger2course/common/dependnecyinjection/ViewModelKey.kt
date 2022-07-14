package com.techyourchance.dagger2course.common.dependnecyinjection

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

//out ViewModel - 뷰모델 일부 하위 클래스에 대한 콘텐츠를 제공할 것이다
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)