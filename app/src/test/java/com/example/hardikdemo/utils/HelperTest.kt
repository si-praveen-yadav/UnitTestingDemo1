package com.example.hardikdemo.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper
    // If we went to check any thing before the check any test case
    // Then We'll use @Before annotation.
    // Function naming must be setUp for easily identify.
    @Before
    fun setUp(){
        helper = Helper()
        println("Before every test cases")
    }

    // If we went to check any thing after the check any test case
    // Then We'll use @After annotation.
    // Function naming must be tearDown for easily identify.
    @After
    fun tearDown(){
        println("After every test cases")
    }

    @Test
    fun isPallindrome() {
        // ARRANGE
        val helper = Helper()
        // ACT
        val result = helper.isPallindrome("hello")
        // ASSERT
        assertEquals(false, result)
    }

    // TODO Set function name as what we expected.
    // Here we are expecting value true. So, we've setup level is true.
    // It can be very easy to understand what we expecting from particular function
    // Always check test-coverage. It's must be greater the 80% success.
    @Test
    fun isPallindrome_insert_value_level_expected_true() {
        // ARRANGE
        val helper = Helper()
        // ACT
        val result = helper.isPallindrome("level")
        // ASSERT
        assertEquals(true, result)
    }

    @Test
    fun isPallindrome_insert_value_a_expected_true() {
        // ARRANGE
        //val helper = Helper()
        // ACT
        val result = helper.isPallindrome("a")
        // ASSERT
        assertEquals(true, result)
    }

    @Test
    fun isPallindrome_insert_value_trial_expected_false() {
        // ARRANGE
        //val helper = Helper()
        // ACT
        val result = helper.isPallindrome("trial")
        // ASSERT
        assertEquals(false, result)
    }

}