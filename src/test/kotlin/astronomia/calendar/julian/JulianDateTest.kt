package astronomia.calendar.julian

import de.wariashi.astronomia.calendar.julian.JulianDate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.ZoneOffset

internal class JulianDateTest {
    @Test
    fun testReferenceEpoch() {
        val referenceEpoch = LocalDateTime.of(-4713, 11, 24, 12, 0).atZone(ZoneOffset.UTC).toInstant()
        val date = JulianDate.of(referenceEpoch)
        Assertions.assertEquals(0.0, date.getValue())
    }

    @Test
    fun testReferenceEpochForJ2000() {
        val referenceEpoch = LocalDateTime.of(2000, 1, 1, 11, 58, 55, 816_000_000).atZone(ZoneOffset.UTC).toInstant()
        val date = JulianDate.of(referenceEpoch)
        Assertions.assertEquals(0.0, date.getValueForJ2000())
    }

    @Test
    fun testReferenceEpochForModifiedJulianDate() {
        val referenceEpoch = LocalDateTime.of(1858, 11, 17, 0, 0).atZone(ZoneOffset.UTC).toInstant()
        val date = JulianDate.of(referenceEpoch)
        Assertions.assertEquals(0.0, date.getValueForModifiedJulianDate())
    }
}
