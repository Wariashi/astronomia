package astronomia.util

import de.wariashi.astronomia.util.Angle
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AngleTest {
    @Test
    fun testDegreesToDegrees() {
        Assertions.assertEquals(-90.0, Angle.inDegrees(-90.0).inDegrees())
        Assertions.assertEquals(0.0, Angle.inDegrees(0.0).inDegrees())
        Assertions.assertEquals(90.0, Angle.inDegrees(90.0).inDegrees())
    }

    @Test
    fun testDegreesToRadians() {
        Assertions.assertEquals(-Math.PI, Angle.inDegrees(-180.0).inRadians())
        Assertions.assertEquals(0.0, Angle.inDegrees(0.0).inRadians())
        Assertions.assertEquals(Math.PI, Angle.inDegrees(180.0).inRadians())
    }

    @Test
    fun testRadiansToDegrees() {
        Assertions.assertEquals(-180.0, Angle.inRadians(-Math.PI).inDegrees())
        Assertions.assertEquals(0.0, Angle.inRadians(0.0).inDegrees())
        Assertions.assertEquals(180.0, Angle.inRadians(Math.PI).inDegrees())
    }

    @Test
    fun testRadiansToRadians() {
        Assertions.assertEquals(-Math.PI, Angle.inRadians(-Math.PI).inRadians())
        Assertions.assertEquals(0.0, Angle.inRadians(0.0).inRadians())
        Assertions.assertEquals(Math.PI, Angle.inRadians(Math.PI).inRadians())
    }
}
