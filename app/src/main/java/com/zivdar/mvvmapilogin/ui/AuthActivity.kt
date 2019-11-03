package com.zivdar.mvvmapilogin.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import com.zivdar.mvvmapilogin.R
import androidx.databinding.DataBindingUtil
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zivdar.mvvmapilogin.data.hide
import com.zivdar.mvvmapilogin.data.show
import com.zivdar.mvvmapilogin.data.toast
import com.zivdar.mvvmapilogin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class AuthActivity : AppCompatActivity(), AuthListener {

    override fun OnSuccess(loginResponse: LiveData<String>) {
        progressBar_start.hide()

        loginResponse.observe(this, Observer {
            toast(it)
        })

    }

    override fun Onstarted() {
        runOnUiThread(Runnable {
            progressBar_start.show()

        })
    }

    override fun OnFailer(message: String) {
        progressBar_start.hide()

        toast(message)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val vm = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.vView = vm
        vm.authListener=this


    }
}
