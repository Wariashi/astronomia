package de.wariashi.astronomia.planet

import de.wariashi.astronomia.calendar.julian.J2000
import de.wariashi.astronomia.util.Angle

/**
 * A [Planet] is an astronomical body that meets the following conditions:
 * - It orbits a star.
 * - It is in hydrostatic equilibrium and therefore almost round due to its own gravity.
 * - It has cleared its orbit of other objects.
 */
interface Planet {
    /**
     * Returns the orbital eccentricity.
     *
     * - If this value is 0, the orbit is a perfect circle.
     * - If this value is between 0 and 1 (exclusive), the orbit is elliptic.
     * - If this value is 1, the trajectory is parabolic.
     * - If this value is greater than 1, the trajectory is hyperbolic.
     *
     * @return the orbital eccentricity
     */
    fun getOrbitalEccentricity(): Double

    /**
     * Calculates the solar mean anomaly for a given date in the [J2000] epoch.
     *
     * **Perihelion** is the point in a [Planet]'s orbit where the [Planet] is closest to the sun.
     * The **anomaly** is the fraction of the orbit that the [Planet] has passed since it has passed perihelion.
     * Due to the elliptic orbit of the [Planet] around the sun, the speed is not constant.
     * The **solar mean anomaly** is the anomaly of a fictitious [Planet] with a constant speed.
     *
     * @param j2000 the date to calculate the solar mean anomaly for
     *
     * @return the solar mean anomaly
     */
    fun getSolarMeanAnomaly(j2000: J2000): Angle {
        val anomalyAtJ2000 = getSolarMeanAnomalyAtJ2000().inDegrees()
        val changePerDay = getSolarMeanAnomalyChangePerDay().inDegrees()
        val days = j2000.getValue()
        val anomaly = anomalyAtJ2000 + (changePerDay * days)
        return Angle.inDegrees(anomaly % 360)
    }

    /**
     * Returns the solar mean anomaly at the beginning of the [J2000] epoch.
     *
     * **Perihelion** is the point in a [Planet]'s orbit where the [Planet] is closest to the sun.
     * The **anomaly** is the fraction of the orbit that the [Planet] has passed since it has passed perihelion.
     * Due to the elliptic orbit of the [Planet] around the sun, the speed is not constant.
     * The **solar mean anomaly** is the anomaly of a fictitious [Planet] with a constant speed.
     *
     * @return the solar mean anomaly at the beginning of the [J2000] epoch
     */
    fun getSolarMeanAnomalyAtJ2000(): Angle

    /**
     * Returns the change in solar mean anomaly per day.
     *
     * **Perihelion** is the point in a [Planet]'s orbit where the [Planet] is closest to the sun.
     * The **anomaly** is the fraction of the orbit that the [Planet] has passed since it has passed perihelion.
     * Due to the elliptic orbit of the [Planet] around the sun, the speed is not constant.
     * The **solar mean anomaly** is the anomaly of a fictitious [Planet] with a constant speed.
     *
     * @return the change in solar mean anomaly per day
     */
    fun getSolarMeanAnomalyChangePerDay(): Angle
}
