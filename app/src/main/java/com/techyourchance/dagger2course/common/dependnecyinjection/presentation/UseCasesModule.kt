package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides

/**
 * 모든 모듈은 그래프 객체를 공유한다
 *  * 이 모듈에서 프레젠테이션 모듈이 제공하는 것을 사용할 수 있다(서브 컴포넌트를 사용하지 않는 경우에도)
 */
@Module
class UseCasesModule {
/*    @Provides
    fun fetchQuestionsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionsUseCase(stackoverflowApi)*/
/*
    @Provides
    fun fetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi) = FetchQuestionDetailsUseCase(stackoverflowApi)*/
}