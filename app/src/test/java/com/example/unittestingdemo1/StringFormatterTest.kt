package com.example.unittestingdemo1

import org.junit.Assert.*
import org.junit.Test

class StringFormatterTest {

    val stringFormatter = StringFormatter()
    @Test
    fun stringFormatter_palindromeString_returnsTrue(){
        val testString = "MADAM"
        assertTrue(stringFormatter.isPalindrome(testString))
    }

    @Test
    fun stringFormatter_nonPalindromeString_returnsFalse(){
        val testString = "SPORTS"
        assertFalse(stringFormatter.isPalindrome(testString))
    }

    @Test
    fun stringFormatter_countLengthSports_returns6(){
        val testString = "SPORTS"
        assertEquals(6,stringFormatter.countLength(testString))
    }
}