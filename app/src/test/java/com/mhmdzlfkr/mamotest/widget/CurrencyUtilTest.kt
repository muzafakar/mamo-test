package com.mhmdzlfkr.mamotest.widget

import org.hamcrest.core.Is.`is`
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CurrencyUtilTest {
    private lateinit var currencyUtil: CurrencyUtil

    @Before
    fun setUp() {
        currencyUtil = CurrencyUtil()
    }

    @Test
    fun isDecimalStringValid_halfDecimalAmount_returnsValid() {
        val input = "10000.1"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_noDecimalAmount_returnsValid() {
        val input = "10000."
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_fullDecimalAmount_returnsValid() {
        val input = "10000.12"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(true))
    }

    @Test
    fun isDecimalStringValid_excessiveDecimalAmount_returnsInvalid() {
        val input = "10000.123"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_excessiveComma_returnsInvalid() {
        val input = "10000..123"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

   @Test
    fun isDecimalStringValid_excessiveCommaEnd_returnsInvalid() {
        val input = "10000.123."
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_commaLeadingAmountAndExcessiveDecimal_returnsInvalid() {
        val input = ".123"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_commaLeadingAmount_returnsInvalid() {
        val input = ".12"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_zeroLeadingAmount_returnsValid() {
        val input = "0.12"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(true))
    }

 @Test
    fun isDecimalStringValid_zeroLeadingAmountAndExcessiveDecimal_returnsInvalid() {
        val input = "0.123"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_normalAmount_returnsInvalid() {
        val input = "10000"
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }

    @Test
    fun isDecimalStringValid_emptyAmount_returnsInvalid() {
        val input = ""
        val result = currencyUtil.isDecimalStringValid(input)
        Assert.assertThat(result, `is`(false))
    }
}