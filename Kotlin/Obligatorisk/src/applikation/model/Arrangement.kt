package applikation.model

class Arrangement(
    val navn: String,
    val offentlig: Boolean
) {
    val getNavn: String
        get() = navn

    val isOffentlig: Boolean
        get() = offentlig

    val _reservationer: MutableList<Reservation> = mutableListOf()
    val reservation: List<Reservation>
        get() = _reservationer

    fun addBooking(reservation: Reservation) = _reservationer.add(reservation)
    fun removeBooking(reservation: Reservation) = _reservationer.remove(reservation)

    fun antalReserveredePladser(): Int {
        return _reservationer.flatMap { it.pladser }.distinct().count()
    }
}
