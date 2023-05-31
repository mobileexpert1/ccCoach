package com.cccoach.viewmodel

import android.app.Application
import com.cccoach.R

class LoginViewModel {

   /* fun isLoginValid() {
        if (isValidLogin()) {

        }
    }*/

    private fun isValidMail(email: String): Boolean {
        return email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex())
    }

   /* fun isValidLogin(): Boolean {
        when {
            email.value.isNullOrEmpty() -> getNavigator()?.showError(
                getApplication<BaseApp>().getString(
                    R.string.please_enter_email_address

                )
            )
            !isValidMail(email.value.toString().trim()) -> getNavigator()?.showError(
                getApplication<BaseApp>().getString(R.string.plz_enter_valid_email_address)
            )
            password.value.isNullOrEmpty() -> getNavigator()?.showError(
                getApplication<BaseApp>().getString(
                    R.string.please_enter_password

                )
            )
            else -> return true
        }
        return false
    }*/

}