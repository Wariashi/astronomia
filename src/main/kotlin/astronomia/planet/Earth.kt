package de.wariashi.astronomia.planet

import de.wariashi.astronomia.calendar.julian.J2000

/**
 * Represents the planet you probably live on.
 */
object Earth {
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
    fun getMeanSolarTime(j2000: J2000, longitude: Double): J2000 {
        return J2000(j2000.getValue() - (longitude / 360))
    }
}
