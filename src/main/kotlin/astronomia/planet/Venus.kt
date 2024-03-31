package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the second [Planet] from the sun.
 */
object Venus : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.006772
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(50.4161)
    }

    override fun getSolarMeanAnomalyChangePerDay(): Angle {
        return Angle.inDegrees(1.60213034)
    }
}
