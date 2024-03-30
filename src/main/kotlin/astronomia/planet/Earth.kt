package de.wariashi.astronomia.planet

import de.wariashi.astronomia.calendar.julian.J2000
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
     * Calculates the mean solar time for a given date in the [J2000] epoch at a given longitude.
     *
     * A **solar day** is the time it takes from noon to noon.
     * The **apparent solar time** is the westward hour angle of the sun with 0° at noon and 180° at midnight.
     * Due to the elliptic orbit of the earth around the sun, the angular velocity is not constant.
     * The **mean solar time** is the hour angle of a fictitious sun with a constant angular velocity.
     *
     * @param j2000 the date in the [J2000] epoch
     * @param longitude the longitude of the observer on earth
     *
     * @return the mean solar time for a given date in the [J2000] epoch at a given longitude
     */
    fun getMeanSolarTime(j2000: J2000, longitude: Angle): J2000 {
        return J2000(j2000.getValue() - (longitude.inDegrees() / 360))
    }

    override fun getOrbitalEccentricity(): Double {
        return 0.0167086
    }

    /**
     * Calculates the solar mean anomaly for a given date in the [J2000] epoch.
     *
     * **Perihelion** is the point in earth's orbit where the earth is closest to the sun.
     * The **anomaly** is the fraction of the orbit that the earth has passed since it has passed perihelion.
     * Due to the elliptic orbit of the earth around the sun, the speed is not constant.
     * The **solar mean anomaly** is the anomaly of a fictitious earth with a constant speed.
     *
     * @param j2000 the mean solar time in the [J2000] epoch
     *
     * @return the solar mean anomaly
     */
    fun getSolarMeanAnomaly(j2000: J2000): Angle {
        val referenceAnomaly = 357.5291
        val changePerDay = 0.98560028
        val days = j2000.getValue()
        val anomaly = referenceAnomaly + (changePerDay * days)
        return Angle.inDegrees(anomaly % 360)
    }
}
