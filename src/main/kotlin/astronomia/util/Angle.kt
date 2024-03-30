package de.wariashi.astronomia.util

/**
 * Represents an [Angle] that can be in degrees or radians.
 */
class Angle private constructor(
    /**
     * The [Angle] in degrees.
     */
    private val degrees: Double
) {
    /**
     * @return the [Angle] in degrees
     */
    fun inDegrees(): Double {
        return degrees
    }

    /**
     * @return the [Angle] in radians
     */
    fun inRadians(): Double {
        val radians = Math.toRadians(degrees)
        return radians
    }

    override fun toString(): String {
        val radians = Math.toRadians(degrees)
        return "Angle(degrees=" + degrees + "°, radians=" + radians + "rad)"
    }

    companion object {
        /**
         * Creates an [Angle] in degrees.
         *
         * @param degrees the [Angle] in degrees
         *
         * @return the [Angle] in degrees
         */
        fun inDegrees(degrees: Double): Angle {
            return Angle(degrees = degrees)
        }

        /**
         * Creates an [Angle] in radians.
         *
         * @param radians the [Angle] in radians
         *
         * @return the [Angle] in radians
         */
        fun inRadians(radians: Double): Angle {
            val degrees = Math.toDegrees(radians)
            return Angle(degrees = degrees)
        }
    }
}
