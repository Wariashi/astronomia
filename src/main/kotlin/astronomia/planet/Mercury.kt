package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the first [Planet] from the sun.
 */
object Mercury : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.20563
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(174.7948)
    }
}
