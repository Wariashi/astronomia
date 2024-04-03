package de.wariashi.astronomia.calendar.julian

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * The [JulianDate] corresponds to the number of days that have passed since November 24, -4713, 12:00 UTC in the Gregorian calendar.
 *
 * @param value the number of days that have passed since November 24, -4713, 12:00 UTC in the Gregorian calendar
 */
class JulianDate(private val value: Double) {
    /**
     * @return the number of days that have passed since November 24, -4713, 12:00 UTC in the Gregorian calendar
     */
    fun getValue(): Double {
        return value
    }

    /**
     * @return the number of days that have passed since January 1, 2000, 12:00 TT in the Gregorian calendar
     */
    fun getValueForJ2000(): Double {
        return value + OFFSET_TO_J2000
    }

    /**
     * @return the number of days that have passed since November 17, 1858, 0:00 UTC in the Gregorian calendar
     */
    fun getValueForModifiedJulianDate(): Double {
        return value + OFFSET_TO_MODIFIED_JULIAN_DATE
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        /**
         * The number of milliseconds in a day.
         */
        private const val MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1_000

        /**
         * The offset between a [JulianDate] and the J2000 epoch.
         */
        private const val OFFSET_TO_J2000 = -2_451_544.9992571296

        /**
         * The offset between a [JulianDate] and the corresponding Modified Julian Date.
         */
        private const val OFFSET_TO_MODIFIED_JULIAN_DATE = -2_400_000.5

        /**
         * The reference epoch, meaning that the [JulianDate] `0.0` corresponds to this date in the Gregorian calendar.
         */
        private val referenceEpoch = LocalDateTime.of(-4713, 11, 24, 12, 0).atOffset(ZoneOffset.UTC).toInstant()

        /**
         * Creates a [JulianDate] representing the current time.
         *
         * @return a [JulianDate] representing the current time
         */
        fun now(): JulianDate {
            val currentDateTime = Instant.now()
            return of(currentDateTime)
        }

        /**
         * Creates a [JulianDate] representing the given time.
         *
         * @param instant the time reference for creating the [JulianDate]
         *
         * @return a [JulianDate] representing the given time
         */
        fun of(instant: Instant): JulianDate {
            val dateTimeInMilliseconds = (1_000 * instant.epochSecond) + (instant.nano / 1_000_000)
            val referenceInMilliseconds = (1_000 * referenceEpoch.epochSecond) + (referenceEpoch.nano / 1_000_000)
            val differenceInMilliseconds = dateTimeInMilliseconds - referenceInMilliseconds
            val julianDay = differenceInMilliseconds.toDouble() / MILLISECONDS_PER_DAY.toDouble()

            return JulianDate(julianDay)
        }

        /**
         * Creates a [JulianDate] in the J2000 epoch.
         *
         * @param j2000 the time reference for creating the [JulianDate]
         *
         * @return a [JulianDate] in the J2000 epoch
         */
        fun ofJ2000(j2000: Double): JulianDate {
            return JulianDate(j2000 - OFFSET_TO_J2000)
        }

        /**
         * Creates a [JulianDate] based on a Modified Julian Date.
         *
         * @param modifiedJulianDate the time reference for creating the [JulianDate]
         *
         * @return a [JulianDate] based on the Modified Julian Date
         */
        fun ofModifiedJulianDate(modifiedJulianDate: Double): JulianDate {
            return JulianDate(modifiedJulianDate - OFFSET_TO_MODIFIED_JULIAN_DATE)
        }
    }
}
