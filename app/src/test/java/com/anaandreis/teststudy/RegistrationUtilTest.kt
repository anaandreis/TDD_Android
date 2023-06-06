package com.anaandreis.teststudy


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`(){
    val result = RegistrationUtil.validateRegistrationInput(
        username = "",
        password = "123",
        confirmPassword = "123"
    )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ana",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Carl",
            password = "123",
            confirmPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username valid password empty return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ana",
            password = "",
            confirmPassword = ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username valid password repeated incorrectly return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ana",
            password = "123",
            confirmPassword = "321"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username valid password contains less than 2 digits return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            username = "Ana",
            password = "abcd1",
            confirmPassword = "abcd1"
        )
        assertThat(result).isFalse()
    }

}