package nix.summer.practice.chatbot
/*
*
*  Stage 3
*
*/
fun age(remainder3:Double, remainder5: Double, remainder7:Double): Int {
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    return age.toInt()
}

fun floatingPoint(fl: Double): Double {
    var numberD: String = java.lang.String.valueOf(fl)
    numberD = numberD.substring(numberD.indexOf(".") + 1)
    return numberD.toDouble()
}

fun guessing() {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")

    // Data input

    enter();
    val remainder3 = readLine()!!.toDouble()
    enter();
    val remainder5 = readLine()!!.toDouble()
    enter();
    val remainder7 = readLine()!!.toDouble()

    // Variables

    val flR3  = floatingPoint(remainder3)
    val flR5  = floatingPoint(remainder5)
    val flR7  = floatingPoint(remainder7)

    // Determining the Type of Number and Counting

    val yourAge = if ((flR3 == 0.0) and (flR5 == 0.0) and (flR7 == 0.0)) {
        //  For integer inputs
        age(remainder3, remainder5, remainder7)
    } else {
        // For floating point number
        age(flR3, flR5, flR7)
    }
    println("Your age is $yourAge; that's a good time to start programming!")
}