package com.zivdar.mvvmapilogin.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.zivdar.mvvmapilogin.data.Repository.UserRepository

class AuthViewModel : ViewModel() {
    var email: String? = null
    var pass: String? = null
     var authListener : AuthListener? = null
    fun onLoginButton(v: View) {

        authListener?.Onstarted()

        if (email.isNullOrEmpty() || pass.isNullOrEmpty()) {
            authListener?.OnFailer("Invalid ")
            return
        }

        val  loginResponse=UserRepository().userLogin(email!!, pass!!)
        authListener?.OnSuccess(loginResponse)

    }
}