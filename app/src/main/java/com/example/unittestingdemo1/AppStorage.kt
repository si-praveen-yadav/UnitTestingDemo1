package com.example.unittestingdemo1

import android.content.SharedPreferences


class AppStorage(
    private val mSharedPreferences: SharedPreferences
) {

    fun saveUserData(userModel: UserModel): Boolean {

        val editor = mSharedPreferences.edit()
        editor.putString(KEY_FIRST_NAME, userModel.firstName)
        editor.putString(KEY_LAST_NAME, userModel.firstName)
        editor.putString(KEY_EMAIL, userModel.email)
        editor.putInt(KEY_AGE, userModel.age)

        return editor.commit()
    }
    val user: UserModel
        get() {
            val firstName = mSharedPreferences.getString(KEY_FIRST_NAME, "").toString()
            val lastName = mSharedPreferences.getString(KEY_LAST_NAME, "").toString()
            val email = mSharedPreferences.getString(KEY_EMAIL, "").toString()
            val age = mSharedPreferences.getInt(KEY_AGE, 0)
            return UserModel(firstName,lastName,email,age)
        }

    companion object {

        const val KEY_FIRST_NAME = "key_first_name"
        const val KEY_LAST_NAME = "key_last_name"
        const val KEY_EMAIL = "key_email"
        const val KEY_AGE = "key_age"

    }
}