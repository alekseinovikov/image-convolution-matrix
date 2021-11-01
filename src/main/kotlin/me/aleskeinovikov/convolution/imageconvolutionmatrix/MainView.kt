package me.aleskeinovikov.convolution.imageconvolutionmatrix

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.FileChooser
import tornadofx.*

class MainView : View("Image Convolution Matrix") {
    private val fileChooser = FileChooser().also {
        it.title = "Open image file"
        it.extensionFilters.addAll(
            FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"),
        )
    }

    override val root = vbox {
        hbox {
            val imageView = imageview {
            }
            button("Open image") {
                setOnMouseClicked {
                    fileChooser.showOpenDialog(this@MainView.currentWindow)?.let {
                        val url = it.toURI().toURL()
                        imageView.image = Image(url.toString())
                        imageView.autoScale()
                    }
                }
            }
        }

        hbox {

        }
    }

    private fun ImageView.autoScale() {
        this.fitWidth = 400.0
    }
}