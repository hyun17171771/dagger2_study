package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import com.techyourchance.dagger2course.screens.viewmodel.ViewModelActivity
import dagger.Subcomponent

/**
 * 컴포넌트는 데거에서 인젝터이다.
 * 따라서 모듈에 대한 추가적인 추상화 수준이 필요하다
 * 모듈은 기본적으로 구성 규칙이고, 객체를 구성한다.
 * 컴포넌트는 이러한 구성된 객체를 가져와서 주입하는 방법을 알고 있다
 *
 * 종속 컴포넌트는 다른 컴포넌트 간에 서비스를 공유하기 매우 쉽다
 * 규칙은 기본적으로 컴포넌트 상호 종속성이 @Component 주석의 일부로 지정된다
 *
 * A 컴포넌트에 의존성을 갖는 B 컴포넌트는 암시적으로 A에 노출된 모든 서비스에 접근할 수 있다.
 * 먼저 A가 제공하는 서비스를 B가 Inject 할 수 있다.
 * 그리고 A의 서비스가 B의 모듈 내에서 소비될 수 있다.
 *
 *
 * 서브컴포넌트는 부모컴포넌트로부터 제공되는 모든 서비스에 접근할 수 있다
 * dependancy 를 사용할 때는 모든 서비스를 명시적으로 노출해야 하지만 서브 컴포넌트 규칙으로 전환하면
 * 모든 종속성과 모든 것을 뒤에서 연결한]
 *
 * 하나의 컴포넌트는 여러개의 모듈을 사용할 수 있다 *

 * 모든 모듈은 그래프 객체를 공유한다
 *  * 이 모듈에서 프레젠테이션 모듈이 제공하는 것을 사용할 수 있다(서브 컴포넌트를 사용하지 않는 경우에도)
 *  이 프레젠테이션 컴포넌트가 다른 컴포넌트에 대한 종속성에도 불구하고 다른 구성 요소에서 제공하는 서비스를 계속 재사용할 수 있다.
 *  그래서 대부분의 모듈에는 부트스트랩 매개변수가 없다.
 *ㅡ
 *
 *
 * 두 모듈이 더이상 필요 하지 않으므로 제거
* modules = [PresentationModule::class, UseCasesModule::class]

*/

@PresentationScope
@Subcomponent(modules = [ViewModelsModule::class])
interface PresentationComponent {
    fun inject(activity: QuestionsListActivity)
    fun inject(fragment: QuestionsListFragment)
    fun inject(activity: QuestionDetailsActivity)
    fun inject(activity: ViewModelActivity)
}