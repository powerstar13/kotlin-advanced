fun main() {

    val list = mutableListOf(printHello)

    list[0]() // 배열에서 함수를 꺼내서 사용하려면 ()를 붙이면 된다.

    val func = list[0] // 배열에서 함수를 꺼내서
    func() // 함수를 작동시킨다.

    call(printHello)

    println("---------------------")

    // 함수를 fun으로 만들면 값에 담을 수도 없고, 함수를 인자로 실행하는 함수에 전달할 수도 없다.
//    val list2 = mutableListOf(printNo)
//    call(printNo)

    val result: Int = plus(1, 3, 5)
    println(result)

    println("---------------------")

    val list3 = listOf("a", "b", "c")
    val printStr : (String) -> Unit = { println(it) }
    forEachStr(list3, printStr)

    println("---------------------")

    forEachStr(list3) {
        // 후행 람다 전달
        println(it)
    }

    println("---------------------")

    list3.forEach(printStr)

    println("---------------------")

    val upperCase : (String) -> String = { it.uppercase() }
    println(list3.map(upperCase))

    println("---------------------")

    val func2 = outerFunc()
    func2()

    println("---------------------")

    arg1 {
        // 인자가 한 개일 때는 it을 사용할 수 있다.
        it.length
        it.first()
    }

    arg2 { a: String, b: String -> // 인자가 두 개 이상일 때는 변수명을 잡고 사용해야 한다. (타입까지 명시해주는 것이 가독성에 좋을 수 있다.)
        a.length
        b.first()
    }

    println("---------------------")

    // 람다 레퍼런스
    val callReference : () -> Unit = { printHello() }
    callReference()
    val callReference2 = ::printHello
    callReference2()()

    val numberList = listOf("1", "2", "3")
    numberList.map { it.toInt() }
        .forEach { println(it) }
    numberList.map(String::toInt) // 클래스나 확장함수인 경우
        .forEach(::println) // 탑-레벨인 경우
}

//val func : () -> Unit = {}
//val func : () -> String = { "" }

val printHello : () -> Unit = { println("Hello") }

/**
 * 함수를 인자로 받아 실행하는 함수
 */
fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No!")

val printMessage : (String) -> Unit = { message: String -> println(message) }
val printMessage2 : (String) -> Unit = { message -> println(message) }
val printMessage3 : (String) -> Unit = { println(it) }

val plus : (Int, Int, Int) -> Int = { a, b, c -> a + b + c }

/**
 * 고차함수
 */
fun forEachStr(collection: Collection<String>, action: (String) -> Unit) {

    for (item in collection) {
        action(item)
    }
}

fun outerFunc() : () -> Unit {

//    return fun() { // 익명함수
    return { // 람다함수
        println("이것은 익명함수!")
    }
}
fun outerFunc2() : () -> Unit = { println("이것은 익명함수!") }

val sum : (Int, Int) -> Int = { x: Int, y: Int -> x + y } // 람다 표현식의 전체 식
val sum2 = { x: Int, y: Int -> x + y } // 최대한 생략한 람다 식

fun arg1(block: (String) -> Unit) {}
fun arg2(block: (String, String) -> Unit) {}