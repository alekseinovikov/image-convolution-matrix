package me.aleskeinovikov.convolution.imageconvolutionmatrix

import javafx.application.Application
import javafx.stage.Stage
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import kotlin.reflect.KClass

@SpringBootApplication
class ImageConvolutionMatrixApplication : App(MainView::class) {

	private lateinit var context: ConfigurableApplicationContext

	override fun init() {
		this.context = SpringApplication.run(this.javaClass)
		context.autowireCapableBeanFactory.autowireBean(this)

		FX.dicontainer = object : DIContainer {
			override fun <T : Any> getInstance(type: KClass<T>): T = context.getBean(type.java)
			override fun <T : Any> getInstance(type: KClass<T>, name: String): T = context.getBean(name, type.java)
		}
	}

	override fun start(stage: Stage) {
		super.start(stage)

		stage.width = 800.0
		stage.height = 600.0
	}

	override fun stop() {
		super.stop()
		context.close()
	}

}

fun main(args: Array<String>) {
	Application.launch(ImageConvolutionMatrixApplication::class.java, *args)
}
