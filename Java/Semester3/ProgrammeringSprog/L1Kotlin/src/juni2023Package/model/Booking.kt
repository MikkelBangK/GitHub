package juni2023Package.model

import java.time.LocalDate
import java.time.LocalTime

class Booking(val dato: LocalDate,
              val tid: LocalTime,
              val single: Boolean,
              //link 0..* --- 1 Spiller
              val spiller: Spiller,
              //link
              val bane: Bane) {
    override fun toString(): String {
        return "Booking(dato=$dato, tid=$tid, single=$single, spiller=$spiller, bane=$bane)"
    }
}