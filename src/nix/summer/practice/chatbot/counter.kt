package nix.summer.practice.chatbot
/*
*
*  Stage 4
*
*/
fun counter() {
    println("I will prove to you that I can count to any number you want:")
    enter();
    val count = readLine()!!.toInt()
    for(i in 1..count)
        println("$i !")
}