// 수학의 함수 -> f((1, 3)) = 1 + 3 = 4
// 내부의 괄호를 생략할 수 있다 -> f(1, 3) = 1 + 3 = 4
fun plus(a: Int, b: Int) = a + b

data class Tuple(val a: Int, val b: Int) // 코틀린에서는 2개의 인자를 받아서 처리하는 Tuple의 개념을 Pair를 통해 제공하고 있다.

fun plusTuple(tuple: Tuple) = tuple.a + tuple.b

fun plusPair(pair: Pair<Int, Int>) = pair.first + pair.second // Pair의 첫 번째 인자는 first, 두 번째 인자는 second 프로퍼티에 들어간다.

fun main() {

    println(plus(1, 3)) // 4

    val plusTupleResult = plusTuple(Tuple(1, 3))
    println(plusTupleResult) // 4

    val plusPairResult = plusPair(Pair(1, 3))
    println(plusPairResult) // 4

    // Pair는 불변이다.
    val pair = Pair("A", 1)
//    pair.first = "B" // 컴파일 에러

    // Pair는 data class 기반이다. (copy, componentN 사용 가능)
    val newPair = pair.copy(first = "B")
    println(newPair) // (B, 1)

    val second = newPair.component2()
    println(second) // 1

    // Pair는 불변(immutable) list로 만들 수 있다.
    val list = newPair.toList()
    println(list) // [B, 1]

    // 코틀린은 두 개의 인자를 가지는 Pair가 있는 것처럼, 세 개의 인자를 가지는 Triple도 있다.
    // Pair와 마찬가지로 Triple도 같은 성향을 가지고 있다.
    val triple = Triple("A", "B", "C")
    println(triple) // (A, B, C)
    triple.first
    triple.second
    triple.third
    // 네 개 이상의 인자를 가지는 것은 따로 제공하지 않기 때문에 개발자가 자료구조를 정의해서 써야 한다.

    val newTriple = triple.copy(third = "D")
    println(newTriple) // (A, B, D)
    println(newTriple.component3()) // D

    // 구조분해할당은 componentN을 사용한다.
    val (a, b, c) = newTriple
    println("$a, $b, $c") // A, B, D

    // Triple도 immutable list로 변환이 가능하고 구조분해할당도 가능하다.
    val list3 = newTriple.toList()
    val (a1, a2, a3) = list3
    println("$a1, $a2, $a3") // A, B, D

    // list의 componentN은 최대 5까지만 제공한다. (리스트의 데이터는 무한정 존재할 수 있기 때문)
    list3.component1()
    list3.component2()
    list3.component3()
//    list3.component4()
//    list3.component5()

    val map = mutableMapOf("마스터" to "개발자")

    // map도 구조분해할당을 통해 쉽게 key-value를 가져올 수 있다.
    for ((key, value) in map) {
        println("${key}의 직업은 $value")
    }

    // to는 Pair로 구현되어 있기 때문에 Pair로 작성할 수도 있다.
    val map2 = mutableMapOf(Pair("마스터", "개발자"))
}