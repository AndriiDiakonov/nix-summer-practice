package nix.summer.practice.coffeemachine

enum class Coffee(val water: Int, val coffeeBeans: Int, val milk: Int, val money: Int){
    ESPRESSO(250, 16, 0, 4),
    LATTE(350, 20, 75, 7),
    CAPPUCCINO(200, 12, 100, 6);
}

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var cups = 9
    private var money = 550

    fun action(choice: String): Boolean {
        when(choice) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> coffeeMachineRemaining()
            "exit" -> return false
        }
        return true
    }

    private fun coffeeMachineRemaining () {
        println("\nThe coffee machine has:\n" +
                "${this.water} of water\n" +
                "${this.milk} of milk\n" +
                "${this.coffeeBeans} of coffee beans\n" +
                "${this.cups} of disposable cups\n" +
                "${this.money} of money")
    }

    private fun makeCoffee(coffeeType: Coffee) {
        if (coffeeType.water > this.water) {
            println("Sorry, not enough water!")
            return
        }
        else if (coffeeType.milk > this.milk) {
            println("Sorry, not enough milk!")
            return
        }
        else if (coffeeType.coffeeBeans > this.coffeeBeans) {
            println("Sorry, not enough coffee beans!")
            return
        }
        else if (coffeeType.money < 1) {
            println("Sorry, not enough disposable cups!")
            return
        }   else {
            println("I have enough resources, making you a coffee!")
        }
        cups -= 1
        this.water -= coffeeType.water
        this.coffeeBeans -= coffeeType.coffeeBeans
        this.milk -= coffeeType.milk
        this.money += coffeeType.money
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        enter()
        when (readLine().toString()) {
            "1" -> makeCoffee(Coffee.ESPRESSO)
            "2" -> makeCoffee(Coffee.LATTE)
            "3" -> makeCoffee(Coffee.CAPPUCCINO)
            "back" -> println()
        }
    }

    private fun fill() {
        println("\nWrite how many ml of water do you want to add: ")
        enter()
        val water = readLine()!!.toInt()
        println("Write how many ml of milk do you want to add: ")
        enter()
        val milk = readLine()!!.toInt()
        println("Write how many grams of coffee beans do you want to add: ")
        enter()
        val cofBeans = readLine()!!.toInt()
        println("Write how many disposable cups of coffee do you want to add: ")
        enter()
        val cups = readLine()!!.toInt()
        this.water += water
        this.milk += milk
        this.coffeeBeans += cofBeans
        this.cups += cups
    }

    private fun take() {
        println("\nI gave you ${this.money}")
        this.money = 0
    }
}