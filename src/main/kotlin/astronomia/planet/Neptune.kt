package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the eighth [Planet] from the sun.
 */
object Neptune : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.008678
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(256.225)
    }

    override fun getSolarMeanAnomalyChangePerDay(): Angle {
        return Angle.inDegrees(0.00598103)
    }
}
