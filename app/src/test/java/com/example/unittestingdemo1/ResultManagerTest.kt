package com.example.unittestingdemo1

import org.junit.Assert.*
import org.junit.Test

class ResultManagerTest {
    val resultManager  = ResultManager()

    @Test
    fun resultManager_checkPercentageWith20MarksOf50Total_returnsTrue(){
        assertEquals(40.0,resultManager.calculatePercentage(20,50),0.0)
    }

    @Test
    fun resultManager_checkGradeWith100Percent_returnsTrue(){
        assertEquals(Grade.E,resultManager.checkResult(100))
    }

    @Test
    fun resultManager_checkGradeWith95Percent_returnsTrue(){
        assertEquals(Grade.O,resultManager.checkResult(95))
    }

    @Test
    fun resultManager_checkGradeWith73Percent_returnsTrue(){
        assertEquals(Grade.A,resultManager.checkResult(73))
    }

    @Test
    fun resultManager_checkGradeWith29Percent_returnsTrue(){
        assertEquals(Grade.F,resultManager.checkResult(29))
    }

    @Test
    fun resultManager_checkResultForGradeC_returnsTrue(){
        assertTrue(resultManager.checkPass(Grade.C))
    }
    @Test
    fun resultManager_checkResultForGradeF_returnsFalse(){
        assertFalse(resultManager.checkPass(Grade.F))
    }
}