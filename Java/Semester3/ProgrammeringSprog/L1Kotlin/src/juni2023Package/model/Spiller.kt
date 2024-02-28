package juni2023Package.model

class Spiller(val navn: String, val uddannelse: String) {
// link 1 --- 0.*Booking, komposition
    private val _bookings: MutableList<Booking> = mutableListOf()
    val bookings: List<Booking>
        get() = bookings;
    fun addBooking(booking: Booking) = _bookings.add(booking)

    //s3

    fun samletPris(kategori: Kategori) : Int{
        var samletKatPris = 0
        for (booking in bookings) {
            with(booking) {
                if (kategori == booking.bane.kategori) {
                    samletKatPris += if (booking.single) {
                        booking.bane.kategori.prisKrSingle
                    } else {
                        booking.bane.kategori.prisKrDouble
                    }
                }
            }
        }
        return samletKatPris
    }

    override fun toString(): String {
        return "Spiller(navn='$navn')"
    }

}