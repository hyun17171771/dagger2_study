package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.common.dependnecyinjection.ViewModelKey
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @IntoMap - 동일한 유형의 여러 서비스들이 Map data 구조에 바인딩 되는데 사용할 수 있다
 * 그리고 대거에 의해 생성되는 Map 개개인의 Key는 @Mapkey 주석으로 정의된다
 * 대거는 자동적으로 map을 형성한다 -> Map<key_type, Provider<service_type>>
 */

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun myViewModel(myViewModel: MyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    abstract fun myViewModel2(myViewModel2: MyViewModel2): ViewModel
}