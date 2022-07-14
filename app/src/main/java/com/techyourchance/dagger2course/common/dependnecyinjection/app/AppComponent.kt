package com.techyourchance.dagger2course.common.dependnecyinjection.app

import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityModule
import com.techyourchance.dagger2course.common.dependnecyinjection.service.ServiceModule
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {



    /**
     * 서브 컴포넌트
     * 부모 컴포넌트는 서브컴포넌트를 반환하는 메서드를 노출한다
     * 부트스트랩 종속성 - 데거 외부에서 생성되는 객체에 대한 종속성
     * 액티비티 모듈은 부트스트랩 종속성을 가지고 있으므로 매개변수에 모듈을 추가해줘야 한다
     */
    //fun newActivityComponent(activityModule: ActivityModule) : ActivityComponent


    fun newActivityComponentBuilder() : ActivityComponent.Builder


    fun newServiceComponent(serviceModule: ServiceModule): ServiceModule
}