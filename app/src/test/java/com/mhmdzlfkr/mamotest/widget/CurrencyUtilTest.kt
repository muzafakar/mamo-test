package com.mhmdzlfkr.mamotest.widget

import org.hamcrest.core.Is.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class CurrencyUtilTest {
    private lateinit var currencyUtil: CurrencyUtil

    @Before
    fun setUp() {
        currencyUtil = CurrencyUtil()
    }

    // isDecimalStringValid()

    @Test
    fun isDecimalStringValid_halfDecimalAmount_returnsValid() {
        val input = "10000.1"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_noDecimalAmount_returnsValid() {
        val input = "10000."
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_fullDecimalAmount_returnsValid() {
        val input = "10000.12"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_excessiveDecimalAmount_returnsInvalid() {
        val input = "10000.123"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_excessiveComma_returnsInvalid() {
        val input = "10000..123"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_excessiveCommaEnd_returnsInvalid() {
        val input = "10000.12344."
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_commaLeadingAmountAndExcessiveDecimal_returnsInvalid() {
        val input = ".123"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_commaLeadingAmount_returnsInvalid() {
        val input = ".12"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_zeroLeadingAmount_returnsValid() {
        val input = "0.12"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_zeroLeadingAmountAndExcessiveDecimal_returnsInvalid() {
        val input = "0.123"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_normalAmount_returnsInvalid() {
        val input = "10000"
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_emptyAmount_returnsInvalid() {
        val input = ""
        val result = currencyUtil.isDecimalStringValid(input)
        assertThat(result, `is`(false))
    }

    @Test
    fun formatAmount_emptyAmount_returnValidFormat() {
        val input = ""
        val expected = ""
        val result = currencyUtil.formatAmount(input)
        assertThat(result, `is`(expected))
    }
    @Test
    fun formatAmount_singleAmount_returnValidFormat() {
        val input = "1"
        val expected = "1"
        val result = currencyUtil.formatAmount(input)
        assertThat(result, `is`(expected))
    }

    @Test
    fun formatAmount_dozensAmount_returnValidFormat() {
        val input = "12"
        val expected = "12"
        val result = currencyUtil.formatAmount(input)
        assertThat(result, `is`(expected))
    }

    @Test
    fun formatAmount_hundredsAmount_returnValidFormat() {
        val input = "123"
        val expected = "123"
        val result = currencyUtil.formatAmount(input)
        assertThat(result, `is`(expected))
    }

    @Test
    fun formatAmount_thousandsAmount_returnValidFormat() {
        val input = "1234"
        val expected = "1,234"
        val result = currencyUtil.formatAmount(input)
        assertThat(result, `is`(expected))
    }

    @Test
    fun formatAmount_thousandsAndDozensAmount_returnValidFormat() {
        val input = "12345"
        val expected = "12,345"
        val result = currencyUtil.formatAmount(input)
        assertThat(result, `is`(expected))
    }
}