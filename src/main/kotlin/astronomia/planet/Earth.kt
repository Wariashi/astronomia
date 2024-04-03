package de.wariashi.astronomia.planet

import de.wariashi.astronomia.calendar.julian.JulianDate
import de.wariashi.astronomia.util.Angle
import kotlin.math.sin

/**
 * Represents the third [Planet] from the sun.
 */
object Earth : Planet {
    /**
     * Calculates the difference between the solar mean anomaly and the true anomaly.
     *
     * @param solarMeanAnomaly the solar mean anomaly
     *
     * @return the difference between the solar mean anomaly and the true anomaly
     */
    fun getEquationOfTheCenterValue(solarMeanAnomaly: Angle): Angle {
        val anomalyInRadians = solarMeanAnomaly.inRadians()
        val degrees = 1.9148 * sin(anomalyInRadians) +
                0.02 * sin(2 * anomalyInRadians) +
                0.0003 * sin(3 * anomalyInRadians)
        return Angle.inDegrees(degrees)
    }

    /**
     * Calculates the mean solar time for a given [JulianDate] at a given longitude.
     *
     * A **solar day** is the time it takes from noon to noon.
     * The **apparent solar time** is the westward hour angle of the sun with 0° at noon and 180° at midnight.
     * Due to the elliptic orbit of the earth around the sun, the angular velocity is not constant.
     * The **mean solar time** is the hour angle of a fictitious sun with a constant angular velocity.
     *
     * @param julianDate the date
     * @param longitude the longitude of the observer on earth
     *
     * @return the mean solar time for a given [JulianDate] at a given longitude
     */
    fun getMeanSolarTime(julianDate: JulianDate, longitude: Angle): JulianDate {
        val valueAtJ2000 = julianDate.getValueForJ2000() - (longitude.inDegrees() / 360)
        return JulianDate.ofJ2000(valueAtJ2000)
    }

    override fun getOrbitalEccentricity(): Double {
        return 0.0167086
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(357.5291)
    }

    override fun getSolarMeanAnomalyChangePerDay(): Angle {
        return Angle.inDegrees(0.98560028)
    }
}
