package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the sixth [Planet] from the sun.
 */
object Saturn : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.0565
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(317.0207)
    }
}
