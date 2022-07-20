package nix.summer.practice.mvc

import kotlin.system.exitProcess

fun enter() {
    print("->  ")
}

private val model = Model()
private val controller = Controller(model)

fun main() {
    //  Default data initialization.
    controller.setData()
    begin()
}

// First Menu
fun begin() {
    val view: View
    println("Select Interface 1 - Terminal 2 - Graphical 3 - Exit:")
    enter()
    when(readLine()!!.toInt()) {
        1 -> {
            view = TerminalView(controller)
            controller.attachView(view)
        }
        2 -> {
            view = SwingView(controller)
            controller.attachView(view)
        }
        3 -> exitProcess(0)
    }
    controller.start()
}