package com.example.safebox

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {


    var name:String="safe name"
    var status:String="Safe name is lockec until.."

    fun setname(name1:String){
        name=name1
    }
    fun setstatus(status1:String){
        status=status1
    }
    @JvmName("getName1")
    fun getName():String {
        return name
    }


    @JvmName("getStatus1")
    fun getStatus():String{

        return status
    }
}