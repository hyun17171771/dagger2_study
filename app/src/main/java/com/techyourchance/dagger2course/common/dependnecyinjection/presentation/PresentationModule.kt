package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityComponent
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule() {

/*

    @Provides
    fun viewMvcFactory(layoutInflater: LayoutInflater) = ViewMvcFactory(layoutInflater)

*/

    /**
     * fragmentManager는 액티비티 모듈에서 제공되고 있고
     * dialogsNavigator에 constructor injection을 직접 할 수 있다 -> 틀린 용어
     * 따라서 아래 코드를 지워도 문제없이 작동한다
     */
/*    @Provides
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)*/



}