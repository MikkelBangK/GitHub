package juni2023Package.gui

import juni2023Package.controller.Controller
import javafx.application.Application
import java.time.LocalDate
import java.time.LocalTime

fun main() {
    initStorage()

    Application.launch(Juni2023GUI::class.java)
}

fun initStorage() {
    with(Controller){
        val luksus = opretKategori("Luksus", prisKrSingle = 100, prisKrDouble = 200)
        val mellem = opretKategori("Mellem", prisKrSingle = 50, prisKrDouble = 100)
        val begynder = opretKategori("Begynder", prisKrSingle = 25, prisKrDouble = 50)

        opretBane(1, true, LocalTime.parse("09:00"), LocalTime.parse("17:00"), luksus)
        val bane2 = opretBane(2, true, LocalTime.parse("09:00"), LocalTime.parse("17:00"), luksus)
        val bane3 = opretBane(3, true, LocalTime.parse("09:00"), LocalTime.parse("17:00"), mellem)
        opretBane(4, false, LocalTime.parse("09:00"), LocalTime.parse("17:00"), mellem)
        val bane5 = opretBane(5, false, LocalTime.parse("09:00"), LocalTime.parse("17:00"), begynder)
        opretBane(6, false, LocalTime.parse("09:00"), LocalTime.parse("17:00"), begynder)

        val andreas = opretSpiller("Andreas", "DMU")
        opretSpiller("Petra", "DMU")
        val henrik = opretSpiller("Henrik", "ITA")
        val ulla = opretSpiller("Ulla", "ITA")

        opretBooking(LocalDate.parse("2023-06-20"), LocalTime.parse("10:00"), true, andreas, bane3);
        opretBooking(LocalDate.parse("2023-06-22"), LocalTime.parse("10:00"), false, andreas, bane2);
        opretBooking(LocalDate.parse("2023-06-20"), LocalTime.parse("11:00"), false, henrik, bane3);
        opretBooking(LocalDate.parse("2023-06-20"), LocalTime.parse("16:00"), false, ulla, bane3);
        opretBooking(LocalDate.parse("2023-06-23"), LocalTime.parse("17:00"), true, ulla, bane5);

        Controller.bookingsTilFil("bookings.txt")
    }
}
