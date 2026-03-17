package com.example.tecnicaltaskem

import com.example.tecnicaltaskem.presentation.helpers.InputFieldValidatorUtility
import org.junit.Assert.*
import org.junit.Test

class InputFieldValidatorUtilityTest {

    private val validator = InputFieldValidatorUtility()

    @Test
    fun `isFieldEmpty returns true for empty string`() {
        assertTrue(validator.isFieldEmpty(""))
    }

    @Test
    fun `isFieldEmpty returns false for non-empty string`() {
        assertFalse(validator.isFieldEmpty("not empty"))
    }

    @Test
    fun `isEnglishOnly returns true for basic English text`() {
        assertTrue(validator.isEnglishOnly("HelloWorld123!"))
    }

    @Test
    fun `isEnglishOnly returns false for non-English characters`() {
        assertFalse(validator.isEnglishOnly("Привет"))
        assertFalse(validator.isEnglishOnly("բարև"))
    }

    @Test
    fun `isLengthValid returns true for 8 or more characters`() {
        assertTrue(validator.isLengthValid("12345678"))
        assertTrue(validator.isLengthValid("password123"))
    }

    @Test
    fun `isLengthValid returns false for less than 8 characters`() {
        assertFalse(validator.isLengthValid("1234567"))
    }

    @Test
    fun `containsUppercase returns true when uppercase exists`() {
        assertTrue(validator.containsUppercase("aBcd"))
    }

    @Test
    fun `containsUppercase returns false when no uppercase exists`() {
        assertFalse(validator.containsUppercase("abcd"))
    }

    @Test
    fun `containsLowercase returns true when lowercase exists`() {
        assertTrue(validator.containsLowercase("Abcd"))
    }

    @Test
    fun `containsLowercase returns false when no lowercase exists`() {
        assertFalse(validator.containsLowercase("ABCD"))
    }

    @Test
    fun `containsNumber returns true when number exists`() {
        assertTrue(validator.containsNumber("abc1"))
    }

    @Test
    fun `containsNumber returns false when no number exists`() {
        assertFalse(validator.containsNumber("abcd"))
    }

    @Test
    fun `containsSpecialSymbol returns true when special symbol exists`() {
        assertTrue(validator.containsSpecialSymbol("abc!"))
        assertTrue(validator.containsSpecialSymbol("abc_"))
    }

    @Test
    fun `containsSpecialSymbol returns false when no special symbol exists`() {
        assertFalse(validator.containsSpecialSymbol("abcd123"))
    }

    @Test
    fun `hasValidAtPlacement returns true for exactly one @ symbol not at start or end`() {
        assertTrue(validator.hasValidAtPlacement("user@domain.com"))
    }

    @Test
    fun `hasValidAtPlacement returns false for zero or multiple @ symbols`() {
        assertFalse(validator.hasValidAtPlacement("userdomain.com"))
        assertFalse(validator.hasValidAtPlacement("user@@domain.com"))
    }

    @Test
    fun `containsValidDomain returns true for valid domains`() {
        assertTrue(validator.containsValidDomain("user@example.com"))
        assertTrue(validator.containsValidDomain("user@sub.example.com"))
    }

    @Test
    fun `containsValidExtension returns true for valid extensions`() {
        assertTrue(validator.containsValidExtension("user@example.com"))
        assertTrue(validator.containsValidExtension("user@example.org"))
    }

    @Test
    fun `containsValidLocalPart returns true for valid local parts`() {
        assertTrue(validator.containsValidLocalPart("user123@domain.com"))
        assertTrue(validator.containsValidLocalPart("first.last@domain.com"))
    }

    @Test
    fun `isPasswordValid returns true for valid password`() {
        assertTrue(validator.isPasswordValid("Pass123!"))
    }

    @Test
    fun `isPasswordValid returns false for invalid password`() {
        assertFalse(validator.isPasswordValid("short"))
        assertFalse(validator.isPasswordValid("nouppercase1!"))
        assertFalse(validator.isPasswordValid("NOLOWERCASE1!"))
        assertFalse(validator.isPasswordValid("NoNumber!"))
        assertFalse(validator.isPasswordValid("NoSpecial1"))
    }

    @Test
    fun `isEmailValid returns true for valid email`() {
        assertTrue(validator.isEmailValid("test@example.com"))
    }

    @Test
    fun `isEmailValid returns false for invalid email`() {
        assertFalse(validator.isEmailValid("plainaddress"))
        assertFalse(validator.isEmailValid("@no-local-part.com"))
        assertFalse(validator.isEmailValid("no-domain@.com"))
        assertFalse(validator.isEmailValid("no-extension@domain"))
    }
}