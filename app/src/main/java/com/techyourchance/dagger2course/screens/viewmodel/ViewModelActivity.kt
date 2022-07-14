package com.techyourchance.dagger2course.screens.viewmodel

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar
import com.techyourchance.dagger2course.screens.common.viewmodels.ViewModelFactory
import javax.inject.Inject

class ViewModelActivity : BaseActivity() {

    @Inject lateinit var screensNavigator: ScreensNavigator

    @Inject lateinit var myViewModelFactory: ViewModelFactory

   private lateinit var myViewModel: MyViewModel
   private lateinit var myViewModel2: MyViewModel2

    private lateinit var toolbar: MyToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            screensNavigator.navigateBack()
        }

        myViewModel = ViewModelProvider(this, myViewModelFactory).get(MyViewModel::class.java)
        myViewModel2 = ViewModelProvider(this, myViewModelFactory).get(MyViewModel2::class.java)

        myViewModel.question.observe(this, { questions ->
            Toast.makeText(this, "fetched ${questions.size} questions", Toast.LENGTH_SHORT).show()
        })
    }
}