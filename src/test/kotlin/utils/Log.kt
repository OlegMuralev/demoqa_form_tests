package utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import org.slf4j.LoggerFactory


open class Log {

    private val logger = LoggerFactory.getLogger(Log::class.java)

    fun printLog(s: Any?) {
        logger.info(
            """${ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            } $s  
            """.trimIndent()
        )
    }
}