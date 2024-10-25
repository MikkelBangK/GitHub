package storage

import applikation.model.Arrangement
import applikation.model.Reservation
import applikation.model.Plads
import java.util.*

object Storage {
    private val arrangementer: MutableList<Arrangement> = mutableListOf()
    fun addArrangement(arrangement: Arrangement) {
        arrangementer.add(arrangement)
    }
    fun getArrangementer(): List<Arrangement> {
        return Collections.unmodifiableList(arrangementer)
    }

    private val reservationer: MutableList<Reservation> = mutableListOf()
    fun addReservation(reservation: Reservation) {
        reservationer.add(reservation)
    }
    fun getReservationer(): List<Reservation> {
        return Collections.unmodifiableList(reservationer)
    }

    private val pladser: MutableList<Plads> = mutableListOf()
    fun addPlads(plads: Plads) {
        pladser.add(plads)
    }
    fun getPladser(): List<Plads> {
        return Collections.unmodifiableList(pladser)
    }
}
