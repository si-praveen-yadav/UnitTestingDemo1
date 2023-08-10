package com.example.hardikdemo.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

// TODO Here is the Parameterized Test case Example.
// When the test case is same for multiple times then we'll create Parameterized Test.
// We'll pass the parameter and test the cases.
@RunWith(value = Parameterized::class)
class ParameterizedExample(val input: String, val expectedValue: Boolean) {

    @Test
    fun test(){
        val helper = Helper()
        val result = helper.isPallindrome(input)
        Assert.assertEquals(expectedValue, result)
    }

    companion object{

        // @Parameters will use for to print the test case name.
        // For particular index.

        @JvmStatic
        @Parameters(name = "{index} : {0} is Palindrome {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
            )
        }
    }

}