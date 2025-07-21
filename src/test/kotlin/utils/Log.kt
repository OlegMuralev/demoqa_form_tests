package utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

open class Log {
    fun printLog(s: Any?) {
        println(
            """${ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            } $s  
            """.trimIndent()
        )
    }
}