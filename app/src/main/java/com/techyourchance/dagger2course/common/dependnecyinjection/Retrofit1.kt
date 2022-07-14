package com.techyourchance.dagger2course.common.dependnecyinjection

import javax.inject.Qualifier


/**
 * @Qualifier - 한정자
 *
 * 한정자는 주석 클래스이다
 * 대거의 관점에서는 한정자는 유형의 일부이다
 * 예를 들어 Q1과 Q2는 다른 서비스 유형이다.
 * @Named(String)을 사용할 수도 있지만 String을 잘못 표기하면 오류가 나기 쉽기 때문에 한정자를 쓰는 것이 더 낫다
 */

@Qualifier
annotation class Retrofit1 {
}