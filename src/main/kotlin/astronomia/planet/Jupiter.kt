package de.wariashi.astronomia.planet

import de.wariashi.astronomia.util.Angle

/**
 * Represents the fifth [Planet] from the sun.
 */
object Jupiter : Planet {
    override fun getOrbitalEccentricity(): Double {
        return 0.0489
    }

    override fun getSolarMeanAnomalyAtJ2000(): Angle {
        return Angle.inDegrees(20.0202)
    }

    override fun getSolarMeanAnomalyChangePerDay(): Angle {
        return Angle.inDegrees(0.08308529)
    }
}
