package gui
import applikation.controller.Controller.createArrangement
import applikation.controller.Controller.createKonsolPlads
import applikation.controller.Controller.createPlads
import applikation.controller.Controller.createReservation
import applikation.model.Omraade
import javafx.application.Application.launch
import java.time.LocalDateTime

class App {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val app = App()
            app.initStorage()
            launch(GUI::class.java)
        }
    }
    private fun initStorage() {
        val turneringsomraade = Omraade.TURNERING
        val standardomraade = Omraade.STANDARD
        val børneomraade = Omraade.BØRNE
        val vipOmraade = Omraade.VIP

        val plads1 = createPlads(1, turneringsomraade)
        val plads2 = createPlads(2, turneringsomraade)
        val plads3 = createPlads(3, standardomraade)
        val plads4 = createPlads(4, standardomraade)
        val plads5 = createPlads(5, børneomraade)
        val konsolPlads1 = createKonsolPlads("Playstation 4",1 , vipOmraade)
        val konsolPlads2 = createKonsolPlads("Xbox One",2 , vipOmraade)

        val dotaArrangement = createArrangement("Dota 2 tournament", true)
        val csgoArrangement = createArrangement("CS GO tournament", false)

        val reservation1 = createReservation(
            LocalDateTime.of(2017, 8, 12, 20, 0),
            LocalDateTime.of(2017, 8, 12, 23, 0),
            listOf(plads1, plads2),
            dotaArrangement
        )

        val reservation2 = createReservation(
            LocalDateTime.of(2017, 8, 13, 19, 0),
            LocalDateTime.of(2017, 8, 14, 6, 0),
            listOf(plads3, plads4),
            csgoArrangement
        )

        val reservation3 = createReservation(
            LocalDateTime.of(2017, 8, 14, 19, 0),
            LocalDateTime.of(2017, 8, 15, 6, 0),
            listOf(konsolPlads2),
            csgoArrangement
        )
    }
}