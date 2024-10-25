package applikation.model

import storage.Storage
import java.time.LocalDateTime
import java.time.Duration

open class Plads(
    val nr: Int,
    val omraade: Omraade,
) : Comparable<Plads> {

    private val _reservation: MutableList<Reservation> = mutableListOf()
    private val reservation: List<Reservation>
        get() = _reservation
    fun addReservation(reservation: Reservation) {
        if (!_reservation.contains(reservation)) {
            _reservation.add(reservation)
            reservation.addPlads(this)
        }
    }
    val getNr: Int
        get() = nr

    val getOmraade: Omraade
        get() = omraade


    companion object {
        var standardTimePris: Int = 50
    }

    open fun pris(timer: Int): Double {
        val multiplier = when (omraade) {
            Omraade.VIP -> 1.25
            Omraade.BØRNE -> 0.80
            Omraade.TURNERING -> 1.10
            else -> 1.0
        }
        return standardTimePris * multiplier * timer
    }
    override fun compareTo(other: Plads): Int {
        val omraadeComparison = this.omraade.compareTo(other.omraade)
        return if (omraadeComparison != 0) {
            omraadeComparison
        } else {
            this.nr.compareTo(other.nr)
        }
    }

    fun samletReservationstid(fra: LocalDateTime, til: LocalDateTime): Int {
        return Storage.getReservationer().fold(0) { acc, reservation ->
            val start = maxOf(reservation.start, fra)
            val end = minOf(reservation.slut, til)
            if (start.isBefore(end)) {
                acc + Duration.between(start, end).toHours().toInt()
            } else {
                acc
            }
        }
    }

    override fun toString(): String {
        return "Plads(nr=$nr, omraade=$omraade)"
    }

}