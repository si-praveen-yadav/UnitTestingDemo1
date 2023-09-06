package com.example.hardikdemo.quote

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

// Instrumentation Tests
class QuoteManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun populateQuoteFromAssets() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        // When we pass blank file name then it will showing error.
        // That means this test case is working fine.
        // because populateQuoteFromAssets function will crash while opening asset folder.
//        quoteManager.populateQuoteFromAssets(context, "")

        quoteManager.populateQuoteFromAssets(context, "quotes.json")
    }

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets_success_even_we_pass_blank_name() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }
    @Test
    fun testPopulateQuoteFromAssets_count_valid_json_value() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(7, quoteManager.quoteList.size)
    }


    @Test
    fun testPrevious_quote_expected_correctQuote(){
        // Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuote(arrayOf(
            Quote("test", "1"),
            Quote("test1", "2"),
            Quote("test2", "3")
        ))

        // Act
        val qutoe = quoteManager.getPreviousQuote()
        // Assert

        assertEquals("1", qutoe.author)
    }
}