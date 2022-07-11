package nix.summer.practice.chatbot
/*
*
*  Stage 2
*
*/
fun yorName(): String {
    println("Please, remind me your name.")
    enter();
    val name = readLine().toString()
    println("What a great name you have, $name!")
    return name
}