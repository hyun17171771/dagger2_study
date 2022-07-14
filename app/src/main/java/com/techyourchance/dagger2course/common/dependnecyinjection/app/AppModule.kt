package com.techyourchance.dagger2course.common.dependnecyinjection.app

import android.app.Application
import com.techyourchance.dagger2course.Constants
import com.techyourchance.dagger2course.common.dependnecyinjection.Retrofit1
import com.techyourchance.dagger2course.common.dependnecyinjection.Retrofit2
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.networking.UrlProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton



@Module
class AppModule(val application: Application) {


    @Provides
    @AppScope
    @Retrofit1
    fun retrofit(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl1())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @AppScope
    @Retrofit2
    fun retrofit2(urlProvider: UrlProvider): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlProvider.getBaseUrl2())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @AppScope
    @Provides
    fun urlProvider() = UrlProvider()

    @Provides
    fun application() = application


    @Provides
    @AppScope
    fun stackoverflowApi(@Retrofit2 retrofit: Retrofit) = retrofit.create(StackoverflowApi::class.java)


}