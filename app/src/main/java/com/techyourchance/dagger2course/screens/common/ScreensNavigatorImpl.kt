package com.techyourchance.dagger2course.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependnecyinjection.activity.ActivityScope
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import javax.inject.Inject

/**
 *  @Inject constructor 을 사용하는 것이 생성 주입라고 부르는 건 잘못된 명명이다.
 *  왜냐하면 모듈에 대해 명시적으로 서비스를 제공하더라도(activity - ActivityModule) 생성자 주입을 하기 때문이다
 *
 *  스크린 네비게이터가 모듈 내부에서 구성되어 있을 때(코드 수정 전)
 *  여전히 동일한 생성자를 사용하고 외부에서 activity를 주입했다.
 *
 *  따라서 주석이 달린 생성자를 주입할 때 암시적으로 제공된 서비스를 사용하거나
 *  모듈 내부에 명시적으로 있을 때 두 경우 모두 생성자 주입을 사용한다.
 *
 *  강사는 이것을 convention of inject annotated constructors, automatic service discovery 부른다
 *
 *
 *  대거는 @Inject annotation 주석이 붙은 생성자가 가진 서비스를 자동적으로 검색할 수 있다
 */

@ActivityScope
class ScreensNavigatorImpl @Inject constructor(private val activity: AppCompatActivity): ScreensNavigator {

    override fun navigateBack() {
        activity.onBackPressed()
    }

    override fun toQuestionDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }
}