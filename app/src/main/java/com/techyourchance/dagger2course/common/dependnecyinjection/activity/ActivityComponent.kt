package com.techyourchance.dagger2course.common.dependnecyinjection.activity


import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent


@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    /**
     * 서브 컴포넌트
     * 부모 컴포넌트는 서브컴포넌트를 반환하는 메서드를 노출한다
     * 프레젠테이션 모듈과 같은 부트스트랩 종속성이 없는 모듈은 매개변수에 넣지 않아도 된다
     * 부트스트랩 종속성 - 데거 외부에서 생성되는 객체에 대한 종속성
     *
     * 강의자는 유지관리 측면에서 모든 모듈을 인수로 넣어줌
     */
    //fun newPresentationComponent() : PresentationComponent

    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity): Builder
        //fun activityModule(activityModule: ActivityModule) : Builder - 자체적으로 생성자 인수 없이 모듈 검색하도록 주석 처리
        fun build() : ActivityComponent
    }
}