package applikation.controller
import applikation.model.*
import java.time.LocalDateTime
import storage.Storage

object Controller {


    fun createPlads(nr: Int, omraade: Omraade): Plads {
        val plads = Plads(nr, omraade)
        Storage.addPlads(plads)
        return plads
    }

    fun createKonsolPlads(type: String, nr: Int, omraade: Omraade): KonsolPlads {
        val konsolPlads = KonsolPlads(type, nr, omraade)
        Storage.addPlads(konsolPlads)
        return konsolPlads
    }

    fun createArrangement(navn: String, offentlig: Boolean): Arrangement {
        val arrangement = Arrangement(navn, offentlig)
        Storage.addArrangement(arrangement)
        return arrangement
    }

    fun createReservation(start: LocalDateTime, slut: LocalDateTime, pladser: List<Plads>, arrangement: Arrangement
    ): Reservation {
        val reservation = Reservation(start, slut)

        pladser.map { plads ->
            plads.also {
                reservation.addPlads(it)
                it.addReservation(reservation)
            }
        }
        arrangement.addBooking(reservation)
        Storage.addReservation(reservation)
        return reservation
    }

    fun findPlads(omraade: Omraade, nr: Int): Plads? {
        val sortedPladser = Storage.getPladser()
            .filter { it.omraade == omraade }
            .sortedBy { it.nr }
            .toTypedArray()
        var left = 0
        var right = sortedPladser.size - 1

        // Binær søgning
        while (left <= right) {
            val mid = (left + right) / 2
            val midPlads = sortedPladser[mid]

            when {
                midPlads.nr == nr -> return midPlads
                midPlads.nr < nr -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return null
    }

    fun reservationsTidPåOmråde(omraade: Omraade, fra: LocalDateTime, til: LocalDateTime): Int {
        return Storage.getPladser().fold(0) { acc, plads ->
            acc + plads.samletReservationstid(fra, til)
        }
    }
}