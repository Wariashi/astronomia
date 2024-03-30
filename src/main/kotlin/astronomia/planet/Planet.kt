package de.wariashi.astronomia.planet

/**
 * A [Planet] is an astronomical body that meets the following conditions:
 * - It orbits a star.
 * - It is in hydrostatic equilibrium and therefore almost round due to its own gravity.
 * - It has cleared its orbit of other objects.
 */
fun interface Planet {
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
}
