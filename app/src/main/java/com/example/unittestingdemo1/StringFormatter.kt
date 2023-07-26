package com.example.unittestingdemo1

class StringFormatter {
    fun isPalindrome(str:String):Boolean{
        return str == str.reversed()
    }

    fun countLength(str:String):Int{
        return str.length
    }
}