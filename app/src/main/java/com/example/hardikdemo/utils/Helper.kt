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

    fun validatePassword(input : String) = when{
        input.isBlank() -> {
            "Please enter password"
        }
        input.length < 6 -> {
            "Password length must be greater then 6"
        }
        input.length > 15 -> {
            "Password length should be less then 15"
        }
        else -> {
            "Valid"
        }

    }


    fun main(){
        println(isPallindrome("hello")) // This is not palindrome so it will return false.
        println(isPallindrome("level")) // This is palindrome so it will return true.
        println(isPallindrome("a")) // This is palindrome so it will return true.
        println(isPallindrome("")) // This is palindrome so it will return true.
    }
}