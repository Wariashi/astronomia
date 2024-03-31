package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the fourth [Planet] from the sun.
 */
object Mars : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.0934
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(19.373)
    }
}
