package com.techyourchance.dagger2course.screens.common.viewsmvc

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.dagger2course.screens.common.imageloader.ImageLoader
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsViewMvc
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListViewMvc
import javax.inject.Inject
import javax.inject.Provider


/**
 * Provider<Type> 래퍼는 대거 객체 그래프의 windows -> 서비스의 싱글 타입을 검색할 수 있게 한다.
 * 프로바이더는 기본적으로 composition root의 확장이다
 * 늦은 주입을 수행해야 할 때 사용한다
 * 대거 내부에 정의된 속성을 프로바이더는 사용하기만 하면 된다
 */
class ViewMvcFactory @Inject constructor(
    private val layoutInflaterProvider: Provider<LayoutInflater>,
    private val imageLoaderProvider: Provider<ImageLoader>
) {

    fun newQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvc(layoutInflaterProvider.get(), parent)
    }

    fun newQuestionDetailsViewMvc(parent: ViewGroup?): QuestionDetailsViewMvc {

        val imageLoader1 = imageLoaderProvider.get()
        val imageLoader2 = imageLoaderProvider.get()
        val imageLoader3 = imageLoaderProvider.get()
        return QuestionDetailsViewMvc(layoutInflaterProvider.get(), imageLoaderProvider.get(), parent)
    }
}