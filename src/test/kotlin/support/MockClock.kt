package support

import java.time.Clock
import java.time.Instant
import java.time.ZoneId

class MockClock : Clock() {
    private var zone = ZoneId.systemDefault()
    private var currentTimeMillis = Clock.systemDefaultZone().millis()

    override fun getZone(): ZoneId {
        return zone
    }

    override fun withZone(zone: ZoneId): Clock {
        val clock = MockClock()
        clock.zone = zone
        clock.currentTimeMillis = currentTimeMillis
        return clock
    }

    override fun instant(): Instant {
        return Instant.ofEpochMilli(currentTimeMillis)
    }
}