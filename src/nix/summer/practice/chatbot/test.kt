package nix.summer.practice.chatbot
/*
*
*  Stage 5
*
*/
fun test(name: String) {
    println("$name, let's check you out.\nYou must choose one correct answer.")
    while (true) {
        println("Does Kotlin have primitive data types like int, long, float?")
        println("1.No, Kotlin does not have or use primitive data types.\n" +
                "2.Yes, Kotlin is similar to Java in this respect.\n" +
                "3.Yes, but Kotlin always converts them to non-original counterparts.\n" +
                "4.No, not at the language level. But the Kotlin compiler uses JVM primitives for better performance.")
        enter();
        when(readLine()!!.toInt()) {
            1, 2,3 -> {
                println("Please, try again")
                continue
            }
            4 -> {
                println("Great, you right!")
                return
            }
            else -> {
                println("Please, try again")
                continue
            }
        }
    }
}