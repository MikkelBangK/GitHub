package gui

import applikation.controller.Controller
import applikation.model.Omraade
import applikation.model.Plads
import javafx.application.Application
import javafx.collections.FXCollections
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import storage.Storage

class GUI : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Netcafé administration"

        val mainVBox = VBox(10.0)
        mainVBox.padding = Insets(10.0)

        val pladserLabel = Label("Pladser:")
        val pladserListView = ListView<Plads>()
        pladserListView.items.addAll(Storage.getPladser())
        pladserListView.prefHeight = 150.0

        val opretStandardPladsButton = Button("Opret standard plads")
        opretStandardPladsButton.setOnAction {
            opretStandardPladsDialog()
        }

        val omraadeLabel = Label("Område:")
        val omraadeGroup = ToggleGroup()
        val standardRadioButton = RadioButton("STANDARD").apply { toggleGroup = omraadeGroup }
        val vipRadioButton = RadioButton("VIP").apply { toggleGroup = omraadeGroup }
        val boerneRadioButton = RadioButton("BØRNE").apply { toggleGroup = omraadeGroup }
        val turneringRadioButton = RadioButton("TURNERING").apply { toggleGroup = omraadeGroup }

        val omraadeVBox = VBox(5.0, standardRadioButton, vipRadioButton, boerneRadioButton, turneringRadioButton)
        omraadeVBox.padding = Insets(5.0, 0.0, 5.0, 0.0)

        omraadeGroup.selectedToggleProperty().addListener{ _, _, newToggle ->
            val selectedRadioButton = newToggle as RadioButton
            val selectedOmradde = when(selectedRadioButton){
                standardRadioButton -> Omraade.STANDARD
                vipRadioButton -> Omraade.VIP
                boerneRadioButton -> Omraade.BØRNE
                turneringRadioButton -> Omraade.TURNERING
                else -> null
            }
            val filteredeBaseret = Storage.getPladser().filter{it.omraade == selectedOmradde}
            pladserListView.items.clear()
            pladserListView.items.addAll(filteredeBaseret)
        }



        val nummerLabel = Label("Nummer:")
        val nummerTextField = TextField()

        val findPladsButton = Button("Find plads")
        val fundetPladsTextField = TextField().apply { isEditable = false }

        findPladsButton.setOnAction {
            val pladsNummer = nummerTextField.text.toIntOrNull()
            val selectedOmraade = when (omraadeGroup.selectedToggle) {
                standardRadioButton -> Omraade.STANDARD
                vipRadioButton -> Omraade.VIP
                boerneRadioButton -> Omraade.BØRNE
                turneringRadioButton -> Omraade.TURNERING
                else -> null
            }

            if (pladsNummer != null && selectedOmraade != null) {
                val plads = Controller.findPlads(selectedOmraade, pladsNummer)
                fundetPladsTextField.text = plads?.toString() ?: "Plads ikke fundet."
            } else {
                fundetPladsTextField.text = "Indtast gyldigt pladsnummer og vælg område."
            }
        }

        val leftVBox = VBox(10.0, pladserLabel, pladserListView, opretStandardPladsButton)
        val rightVBox = VBox(10.0, omraadeLabel, omraadeVBox, nummerLabel, nummerTextField, findPladsButton, fundetPladsTextField)
        rightVBox.alignment = Pos.TOP_LEFT

        val hBox = HBox(10.0, leftVBox, rightVBox)
        mainVBox.children.add(hBox)

        val scene = Scene(mainVBox, 600.0, 400.0)
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun opretStandardPladsDialog() {
        val dialog = Stage()
        dialog.title = "Opret standard plads"

        val vbox = VBox(10.0)
        vbox.padding = Insets(10.0)

        val nummerLabel = Label("Nummer:")
        val nummerTextField = TextField()
        val okButton = Button("OK")
        val cancelButton = Button("Cancel")

        okButton.setOnAction {
            val nummer = nummerTextField.text.toIntOrNull()
            if (nummer != null) {
                val nyPlads = Controller.createPlads(nummer, Omraade.STANDARD)
                Storage.addPlads(nyPlads)
                dialog.close()
            } else {
                val alert = Alert(Alert.AlertType.ERROR)
                alert.contentText = "Indtast et gyldigt nummer."
                alert.showAndWait()
            }
        }

        cancelButton.setOnAction {
            dialog.close()
        }

        val hBoxButtons = HBox(10.0, okButton, cancelButton)
        hBoxButtons.alignment = Pos.CENTER_RIGHT

        vbox.children.addAll(nummerLabel, nummerTextField, hBoxButtons)

        val scene = Scene(vbox, 300.0, 200.0)
        dialog.scene = scene
        dialog.show()
    }
}
