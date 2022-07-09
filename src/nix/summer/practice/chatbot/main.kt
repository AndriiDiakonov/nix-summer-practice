package nix.summer.practice.chatbot

fun enter() {
    print("->  ")
}

fun main() {
    start()
    val name = yorName()
    guessing()
    counter()
    test(name)
    println("Goodbye, have a nice day!")
}