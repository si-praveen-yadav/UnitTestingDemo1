package com.example.hardikdemo.utils

class Helper {

    fun isPallindrome(value: String) : Boolean{

        var i =0
        var j = value.length - 1
        var result = true

        while (i<j){
            if (value[i] != value[j]){
                result = false
                break
            }

            i++
            j--
        }
        return result
    }
}