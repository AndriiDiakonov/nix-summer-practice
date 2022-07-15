package nix.summer.practice.mvc

class TerminalView(override var controller: Controller) : View {

    override fun start() {
        terminalP()
        return
    }

    //  Terminal view
    private fun terminalP() {
        var run = true
        while (run) {
            output("\nWrite action (buy, fill, take, remaining, back):")
            enter()
            when(val choice: String = readLine().toString()) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> {
                    controller.take()
                }
                "remaining" -> {
                    controller.remaining()
                }
                else -> {
                    if (choice != "back") {
                        println("Invalid option.")
                    } else {
                        run = exit()
                        begin()
                    }
                }
            }
        }
    }

    //  Shopping function
    private fun buy() {
        output("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        enter()
        val order = Order(readLine().toString())
        controller.buy(order)
    }

    //  Fill function
    private fun fill() {
        val resources = Resources.ChangeRes()
        output("Write how many ml of water do you want to add:")
        enter()
        resources.water = readLine()!!.toInt()
        output( "Write how many ml of milk do you want to add:")
        enter()
        resources.milk = readLine()!!.toInt()
        output("Write how many grams of coffee beans do you want to add:")
        enter()
        resources.coffeeBeans = readLine()!!.toInt()
        output("Write how many disposable cups of coffee do you want to add:")
        enter()
        resources.cups = readLine()!!.toInt()
        controller.fill(resources)
    }

    //  HTML Convert to text
    private fun replaceText(text: String, value: String, replacing: String): String {
        return text.replace(
            value,
            replacing,
            true
        )
    }

    override fun showInfo(info: String, label: Boolean): String {
        output(info)
        return "Displayed"
    }

    override fun showInfoRes(info: String): String {
        var text = replaceText(info, "<html>", "\n")
        text = replaceText(text, "<h1>", "")
        text = replaceText(text, "</h1>", "")
        text = replaceText(text, "<h3>", "")
        text = replaceText(text, "</h3>", "")
        text = replaceText(text, "<br>", "\n")
        text = replaceText(text, "</html>", "")
        print(text)
        return "Print"
    }

    override fun output(text: String) {
        println(text)
    }

    override fun exit(): Boolean {
        return false
    }
}