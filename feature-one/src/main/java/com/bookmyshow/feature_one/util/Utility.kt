package com.bookmyshow.feature_one.util

import java.text.SimpleDateFormat
import java.util.*

object Utility {
    private val domainTimeFormatter = SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH)
    private val domainDateFormatter = SimpleDateFormat("d MMM',' yyyy", Locale.ENGLISH)

    fun parseRawTime(showDateCode: Long): Date? {
        return try {
            domainTimeFormatter.parse(showDateCode.toString())
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
            null
        }
    }

    fun removeFixesInDateString(dateString: String):String{
        return dateString.replace("st", "").replace("nd", "").replace("rd","").replace("th","")
        //could use regex replace(Regex.fromLiteral("(?<=\\d)(st|nd|rd|th)"), "")
    }

    fun parseRawDate(rawDate: String): Date? {
        return try {
            val cleanedDate = removeFixesInDateString(rawDate)

            return domainDateFormatter.parse(cleanedDate)
        } catch (ex: java.lang.Exception) {
            ex.printStackTrace()
            null
        }
    }
}