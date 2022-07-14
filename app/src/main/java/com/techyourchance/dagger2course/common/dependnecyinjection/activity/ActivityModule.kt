package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.ScreensNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * 대거는 모듈안에서 static 프로파이더에 대한 더 나은 코드를 생성한다 (코틀린 - companion object or top level 객체)
 * 그러나 모든 프로파이더 메서드를 정적으로 만들고 싶으면 부트스트랩을 넣는 것은 문제가 된다
 * -> @Component.Builder를 컴포넌트에 구현
 * 컴포넌트에서 모듈을 주입할 무언가를 실제로 빌드하는 메서드를 정의할 수 있다
 * 또한 @BindsInstance 주석을 사용하면 부트스트랩 종속성을 구성 요소에 직접 주입할 수 있
 * -> 더 성능 좋은 코드이지만 강의자는 복잡성이 추가되는 만큼 이상의 성능 향상은 아니라고 생각하기 때문에 사용하지 않음
 */

@Module
abstract class ActivityModule { //static으로 가능


/*    @Provides
    fun activity() = activity*/


    /**
     @Binds 는 또다른 provided type에게 특정한 provided type를 매핑하게 한다.(인터페이스 구현 제공)
     커스텀 바인딩은 abstract 모듈 안에 abstract 메서드로 정의되어야 한다
     @Binds는 비정적 프로바이더 메서드와 같은 모듈 안에서 공존할 수 없다 -  companion object에 넣어 정적으로 만
     */
    @ActivityScope
    @Binds
    abstract fun screensNavigator(screensNavigatorImpl: ScreensNavigatorImpl): ScreensNavigator

    /**
     * 외부 주입이 필요한 activity이 필요한 아래 두 서비스는
     * 생성자에 대한 주입이 불가하다
     * 따라서 이 두가지 서비스는 명시적으로 제공해야 한다 (삭제할 수 없음)
     */

    companion object {
        @Provides
        fun layoutInflater(activity: AppCompatActivity) = LayoutInflater.from(activity)

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }


}