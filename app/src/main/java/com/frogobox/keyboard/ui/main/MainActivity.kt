package com.frogobox.keyboard.ui.main

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.frogobox.keyboard.core.BaseBindActivity
import com.frogobox.keyboard.databinding.ActivityMainBinding

class MainActivity : BaseBindActivity<ActivityMainBinding>() {

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    private val viewModel: MainViewModel by viewModels()

    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            // Call View Model Here
            Log.d(TAG, "View Model : ${viewModel::class.java.simpleName}")
        }
        // TODO : Add your code here

    }

    override fun initView() {
        super.initView()
        binding.apply {
            btnChangeKeyboard.setOnClickListener {
                (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).showInputMethodPicker()
            }

            btnGoToSetting.setOnClickListener {
                Intent(Settings.ACTION_INPUT_METHOD_SETTINGS).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(this)
                }
            }

        }
    }



    override fun initObserver() {
        super.initObserver()
        viewModel.apply {

        }
    }

}