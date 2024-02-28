package juni2023Package.model

import juni2023Package.storage.Storage
import java.time.LocalDate
import java.time.LocalTime

class Bane(val nummer: Int,
           val inde: Boolean,
           val foersteTid: LocalTime,
           val sidsteTid: LocalTime,
           // link 0..* --> 1 kategori
           val kategori: Kategori) {
    private val _bookings: MutableList<Booking> = mutableListOf()
    val bookings: List<Booking>
        get() = _bookings
    fun addBooking(booking: Booking) = _bookings.add(booking)
    // S2
    fun bookedeTimerPåDato(dato: LocalDate): Int {
        var antalBookedeTimer = 0
        for (booking in bookings) {
            if (dato == booking.dato){
                antalBookedeTimer++
            }
        }
        return antalBookedeTimer
    }
    fun bookedeTimerPåDato1(dato: LocalDate): Int =
        bookings.count { dato == it.dato }

    fun antalBookningerPrTime(): IntArray{
        val count = sidsteTid.hour - foersteTid.hour + 1
        val bookningsCounts = IntArray(count)
        for (hour in foersteTid.hour .. sidsteTid.hour){
            for (booking in bookings){
                if (booking.tid.hour == hour){
                    bookningsCounts[hour - foersteTid.hour]++
                }
            }
        }
        return bookningsCounts
    }

    fun tidLedig(dato: LocalDate, tid: LocalTime): Boolean {
        var found = true
        var i = 0
        while (found && i < bookings.size){
            if (bookings[i].dato == dato && bookings[i].tid == tid){
                found = false
            }
            i++;
        }
        return found
    }

    override fun toString(): String {
        return "Bane(nummer=$nummer, inde=$inde, foersteTid=$foersteTid, sidsteTid=$sidsteTid, kategori=$kategori)"
    }

}