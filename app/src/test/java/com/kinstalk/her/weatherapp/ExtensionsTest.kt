package com.kinstalk.her.weatherapp

import com.kinstalk.her.weatherapp.extensions.toDateString
import org.junit.Test
import java.text.DateFormat
import org.junit.Assert.assertEquals

/**
 * Created by horsege on 2017/7/10.
 */
class ExtensionsTest {
    @Test fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }

    @Test fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015",
                1445275635000L.toDateString(DateFormat.FULL))
    }
}