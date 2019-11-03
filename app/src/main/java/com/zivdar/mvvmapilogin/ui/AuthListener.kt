package com.zivdar.mvvmapilogin.ui

import androidx.lifecycle.LiveData

interface AuthListener {
    fun OnSuccess(loginResponse: LiveData<String>)
     fun Onstarted()
    fun OnFailer(message:String)
}