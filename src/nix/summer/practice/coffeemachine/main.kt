package nix.summer.practice.coffeemachine

fun enter() {
    print("->  ")
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    var run = true
    while (run) {
        println("\nWrite action (buy, fill, take, remaining, exit):")
        enter()
        run = coffeeMachine.action(readLine().toString())
    }
}