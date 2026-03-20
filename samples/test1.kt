fun power(base: Int, exp: Int): Int {
    var res: Int = 1
    var counter: Int = 0
    while (counter < exp) {
        res = res * base
        counter = counter + 1
    }
    return res
}

fun complexLogic(x: Int, y: Int, check: Boolean): String {
    var status: String = "unknown"

    if (check) {
        if (x > 0 && y > 0 || x == 0) {
            status = "positive_or_zero_x"
            if (x + y * 2 > 10) {
                status = "high_value"
            } else {
                status = "low_value"
            }
        } else {
            status = "negative"
        }
    } else {
        status = "disabled"
    }

    return status
}

fun runTests(): Unit {
    var mathTest: Int = 3 + 4 * 2
    println("Math Test (3 + 4 * 2):")
    println(mathTest)

    var logicResult: String = complexLogic(5, 4, true)
    println("Logic Result:")
    println(logicResult)

    var isValid: Boolean = (10 >= 5) && (1 != 2) || false
    println("Boolean Test:")
    println(isValid)

    var p: Int = power(2, 10)
    println("2^10:")
    println(p)
}

fun main(): Unit {
    runTests()
}