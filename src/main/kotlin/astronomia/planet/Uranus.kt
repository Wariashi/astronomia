package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the seventh [Planet] from the sun.
 */
object Uranus : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.04717
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(141.0498)
    }

    override fun getSolarMeanAnomalyChangePerDay(): Angle {
        return Angle.inDegrees(0.01172834)
    }
}
