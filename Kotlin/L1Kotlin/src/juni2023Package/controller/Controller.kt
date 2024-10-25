package juni2023Package.controller

import juni2023Package.model.Bane
import juni2023Package.model.Booking
import juni2023Package.model.Kategori
import juni2023Package.model.Spiller
import juni2023Package.storage.Storage
import java.io.File
import java.io.IOException
import java.io.PrintWriter
import java.time.LocalDate
import java.time.LocalTime

object Controller {

    fun opretSpiller(navn: String, uddannelse: String): Spiller {
        val spiller = Spiller(navn, uddannelse)
        Storage.addSpiller(spiller)
        return spiller
    }

    fun opretBane(nummer: Int, inde: Boolean, foersteTid: LocalTime, sidsteTid: LocalTime, kategori: Kategori): Bane {
        val bane = Bane(nummer, inde, foersteTid, sidsteTid, kategori)
        Storage.addBane(bane)
        return bane
    }

    fun opretKategori(navn: String, prisKrSingle: Int, prisKrDouble: Int): Kategori {
        val kategori = Kategori(navn, prisKrSingle, prisKrDouble)
        Storage.addKategori(kategori)
        return kategori
    }

    fun opretBooking(dato: LocalDate, tid: LocalTime, single: Boolean, spiller: Spiller, bane: Bane): Booking {
        val booking = Booking(dato, tid, single, spiller, bane)
        spiller.addBooking(booking)
        bane.addBooking(booking)
        return booking
    }

    fun samletBookingDoubleTid(uddannelse: String, kategori: Kategori): Int {
        var samletDoubleTid = 0
        for (spiller in Storage.alleSpillere) {
            if (spiller.uddannelse == uddannelse && Storage.alleBaner.any { it.kategori == kategori }) {
                samletDoubleTid++;
            }
        }
        return samletDoubleTid
    }

    fun findLedigBane(dato: LocalDate, tid: LocalTime, kategori: Kategori): Bane? {
        var i = 0;
        var ledigBane: Bane? = null
        while ( ledigBane == null && i < Storage.alleBaner.size){
            val bane = Storage.alleBaner[i]
            if (bane.kategori == kategori && bane.tidLedig(dato, tid)) {
                ledigBane = bane
            }
                i++;
        }
        return ledigBane;
    }

    fun bookingsTilFil(filnavn: String) {
        val file = File("/Users/mikkelkristensen/Desktop/Datamatiker/Ovelse/bookings.txt")
        try {
            val printWriter = PrintWriter(file)
            for (baner in Storage.alleBaner) {
                for (booking in baner.bookings)
                printWriter.println(booking.toString())
            }
            printWriter.close()
            println("Bookinger skrevet til fil")
        } catch (e: IOException) {
            println("Fejl ved skrivning til fil: $e")
        }
    }
}
