package juni2023Package.gui

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.GridPane
import javafx.stage.Stage

class Juni2023GUI: Application() {

    override fun start(primaryStage : Stage?) {
        val stage = primaryStage ?: throw Exception()
        stage.title = "Bane booking"
        val pane = GridPane()
        this.initContent(pane)

        val scene = Scene(pane)
        stage.scene = scene
        stage.show()
    }

    private fun initContent(pane: GridPane) {

    }
}