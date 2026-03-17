package com.example.tecnicaltaskem.presentation.helpers

class InputFieldValidatorUtility {

    fun isFieldEmpty(input: String): Boolean = input.isEmpty()

    fun isEnglishOnly(input: String): Boolean {
        return input.matches(Regex("^[\\x00-\\x7F]+$"))
    }

    fun isLengthValid(input: String): Boolean = input.length >= 8

    fun containsUppercase(input: String): Boolean {
        return input.contains(Regex("[A-Z]"))
    }

    fun containsLowercase(input: String): Boolean {
        return input.contains(Regex("[a-z]"))
    }

    fun containsNumber(input: String): Boolean {
        return input.contains(Regex("[0-9]"))
    }

    fun containsSpecialSymbol(input: String): Boolean {
        return input.contains(Regex("[\\W_]"))
    }

    fun hasValidAtPlacement(input: String): Boolean {
        return input.matches(Regex("^[^@]+@[^@]+$"))
    }

    fun containsValidDomain(input: String): Boolean {
        return input.contains(Regex("@[A-Za-z0-9.-]+\\."))
    }

    fun containsValidExtension(input: String): Boolean {
        return input.contains(Regex("\\.[A-Za-z]{2,}$"))
    }

    fun containsValidLocalPart(input: String): Boolean {
        return input.contains(Regex("^[A-Za-z0-9._%+-]+(?=@)"))
    }

    fun isPasswordValid(input: String) : Boolean {
         return !isFieldEmpty(input) &&
                isEnglishOnly(input) &&
                isLengthValid(input) &&
                containsUppercase(input) &&
                containsLowercase(input) &&
                containsNumber(input) &&
                containsSpecialSymbol(input)
    }

    fun isEmailValid(input: String): Boolean {
        return !isFieldEmpty(input) &&
               isEnglishOnly(input) &&
               hasValidAtPlacement(input) &&
               containsValidLocalPart(input) &&
               containsValidExtension(input) &&
               containsValidDomain(input)
    }
}