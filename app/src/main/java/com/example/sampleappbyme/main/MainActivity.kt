package com.example.sampleappbyme.main

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.sampleappbyme.R
import com.example.sampleappbyme.databinding.ActivityMainBinding
import com.example.sampleappbyme.main.subactivity.AddEditTaskActivity
import com.example.sampleappbyme.main.util.TasksNavigator
import com.example.sampleappbyme.main.util.DessertTimer
import com.example.sampleappbyme.main.util.obtainViewModel
import com.example.sampleappbyme.main.viewmodel.MainViewModel
import com.example.sampleappbyme.main.viewmodel.TaskViewModel


class MainActivity : AppCompatActivity(),
    TasksNavigator {

    private lateinit var navController: NavController
    private var splashShown = false

    private lateinit var dessertTimer: DessertTimer
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host)

        Handler().postDelayed({
            if (!splashShown) {
                navController.navigate(R.id.action_go_to_main_fragment)
                splashShown = true
            }
        }, 1200)

        dessertTimer =
            DessertTimer(this.lifecycle)
    }

    // 다크모드 변경시 앱 재시작을 통한 테마 설정
    // 앱을 재시작하고 있으므로 사용중에 불편함을 초래할 수 있음. 향후 리뷰 요망
    override fun onConfigurationChanged(newConfig: Configuration) {
        finish()
        startActivity(Intent(this@MainActivity, this@MainActivity.javaClass))

        super.onConfigurationChanged(newConfig)
    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_host).navigateUp()

    fun obtainViewModel(): MainViewModel = obtainViewModel(MainViewModel::class.java)

    fun obtainTaskViewModel(): TaskViewModel = obtainViewModel(TaskViewModel::class.java)

    override fun addNewTask() {
        val intent = Intent(this, AddEditTaskActivity::class.java)
        startActivityForResult(intent, AddEditTaskActivity.REQUEST_CODE)
    }

    companion object {
        const val CHANNEL_ID = "TEMP_CHANNEL"
        const val NOTIFICATION_ID = 1

        const val PROGRESS_MAX = 100
        const val PROGRESS_CURRENT = 0
    }
}
