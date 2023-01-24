package com.bookmyshow.feature_one

import com.bookmyshow.feature_one.util.Utility
import org.junit.Test

import org.junit.Assert.*
import java.util.Calendar

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DomainDateFormateTest {

    @Test
    fun provided_time_as_string_and_date_as_code_formatter_formats() {
        val showTimeInStr = "10:15am"
        val showDateCode = 20220501101500

        val timeInEpoch = 1651380300000

        //to get epoch time https://www.epochconverter.com/ use local time

        val formattedDate = Utility.parseRawTime(showDateCode)
        assertEquals(timeInEpoch, formattedDate?.time)
    }

    @Test
    fun provided_st_rd_th_replace() {
        val testVal = "1st May, 2022"

        assertEquals("1 May, 2022", Utility.removeFixesInDateString(testVal))
    }

    @Test
    fun provided_unparsed_date_convert_to_date() {
        val testVal = "1st May, 2022"
        val cal = Calendar.getInstance()
        cal[Calendar.DATE] = 1
        cal[Calendar.MONTH] = 4 // month start from 0
        cal[Calendar.YEAR] = 2022
        cal[Calendar.HOUR_OF_DAY] = 0
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        cal[Calendar.MILLISECOND] = 0

        assertEquals(cal.time.time, Utility.parseRawDate(testVal)?.time)
    }
}