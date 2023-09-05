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

    fun main(){
        println(isPallindrome("hello")) // This is not palindrome so it will return false.
        println(isPallindrome("level")) // This is palindrome so it will return true.
        println(isPallindrome("a")) // This is palindrome so it will return true.
        println(isPallindrome("")) // This is palindrome so it will return true.
    }
}