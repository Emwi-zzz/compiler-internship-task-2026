fun inc(x: Int): Int {
    return x + 1
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun sumThree(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

fun getFive(): Int {
    return 5
}

fun main(): Unit {
    println(inc(getFive()))

    var multi: Int = multiply(getFive(), getFive())
    println(multi)

    var complex: Int = sumThree(multiply(5, getFive()), inc(getFive()), getFive())

    println("Complex Result (Expected 36):")
    println(complex)

    if (inc(getFive()) > 5) {
        println("Nested Call in IF works")
    } else {
        println("Fail")
    }
}