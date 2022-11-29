package com.example.safebox

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesUtils{




    fun getMenuVisibility(mContext: Context):Boolean{
        val sharedPreferences: SharedPreferences =mContext.getSharedPreferences("menuVisibilityPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("menuVisibilityValue",true)
    }

    fun setMenuVisibility(mContext: Context, visibility:Boolean){
        val sharedPreferences: SharedPreferences =mContext.getSharedPreferences("menuVisibilityPrefs", Context.MODE_PRIVATE)
        val sharedPreferencesEditor: SharedPreferences.Editor  = sharedPreferences.edit()
        sharedPreferencesEditor.putBoolean("menuVisibilityValue",visibility)
        sharedPreferencesEditor.apply()
    }
}