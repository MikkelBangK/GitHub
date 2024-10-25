package applikation.model

import java.time.LocalDateTime

class Reservation(
    val start: LocalDateTime,
    val slut: LocalDateTime,
    var arrangement: Arrangement? = null){


    val getStart: LocalDateTime
        get() = start

    val getSlut: LocalDateTime
        get() = slut

    var getArrangement: Arrangement?
        get() = arrangement
        set(value) {
            arrangement = value
        }
    private val _pladser: MutableList<Plads> = mutableListOf()
    val pladser: List<Plads>
        get() = _pladser

    fun addPlads(plads: Plads){
        if (!_pladser.contains(plads)) {
            _pladser.add(plads)
            plads.addReservation(this)
        }
    }
}
