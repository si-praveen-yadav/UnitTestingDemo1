package com.example.unittestingdemo1

import android.content.SharedPreferences
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever


@RunWith(MockitoJUnitRunner::class)
class AppStorageTest {

    private lateinit var userModel: UserModel
    lateinit var mockAppStorage: AppStorage
    lateinit var mockBrokenAppStorage: AppStorage

    @Mock
    lateinit var mMockSharedPreferences: SharedPreferences

    @Mock
    lateinit var mMockBrokenSharedPreferences: SharedPreferences

    @Mock
    lateinit var mMockEditor: SharedPreferences.Editor

    @Mock
    lateinit var mMockBrokenEditor: SharedPreferences.Editor

    @Before
    fun initialize() {
        userModel = UserModel(
            firstName = TEST_FIRSTNAME,
            lastName = TEST_LASTNAME,
            email = TEST_EMAIL,
            age = TEST_AGE
        )

        mockAppStorage = createMockAppStorage()
        mockBrokenAppStorage = createMockBrokenAppStorage()
    }

    @Test
    fun appStorage_readUserInfo_returnsTrue() {
        val savedUserInfo = mockAppStorage.user
        assertEquals(
            "Checking if user firstname was correctly persisted and same",
            userModel.firstName,
            savedUserInfo.firstName
        )
        assertEquals(
            "Checking if user lastname was correctly persisted and same",
            userModel.lastName,
            savedUserInfo.lastName
        )
        assertEquals(
            "Checking if user email was correctly persisted and same",
            userModel.email,
            savedUserInfo.email
        )
        assertEquals(
            "Checking if user age was correctly persisted and equal",
            userModel.age,
            savedUserInfo.age
        )
    }

    @Test
    fun appStorage_saveUserInfo_returnsTrue() {
        assertTrue(mockAppStorage.saveUserData(userModel))
    }

    @Test
    fun appStorage_saveUserInfoWithIncorrectContext_returnsFalse() {
        assertFalse(
            "Trying to write user info with incomplete AppStorage initialization which will return false",
            mockBrokenAppStorage.saveUserData(userModel)
        )
    }

    private fun createMockAppStorage(): AppStorage {
        whenever(mMockSharedPreferences.getString(AppStorage.KEY_FIRST_NAME, "")).thenReturn(
            userModel.firstName
        )
        whenever(mMockSharedPreferences.getString(AppStorage.KEY_LAST_NAME, "")).thenReturn(
            userModel.lastName
        )
        whenever(
            mMockSharedPreferences.getString(
                AppStorage.KEY_EMAIL,
                ""
            )
        ).thenReturn(userModel.email)
        whenever(mMockSharedPreferences.getInt(AppStorage.KEY_AGE, 0)).thenReturn(userModel.age)
        whenever(mMockEditor.commit()).thenReturn(true)

        whenever(mMockSharedPreferences.edit()).thenReturn(mMockEditor)
        return AppStorage(mMockSharedPreferences)
    }

    private fun createMockBrokenAppStorage(): AppStorage {
        whenever(mMockBrokenEditor.commit()).thenReturn(false)

        whenever(mMockBrokenSharedPreferences.edit()).thenReturn(mMockBrokenEditor)
        return AppStorage(mMockBrokenSharedPreferences)
    }

    companion object {
        const val TEST_FIRSTNAME = "Praveen"
        const val TEST_LASTNAME = "Yadav"
        const val TEST_EMAIL = "praveen.yadav@si.com"
        const val TEST_AGE = 22


    }
}
