import java.util.ArrayList
import java.util.LinkedList
import java.util.stream.Collectors

fun main() {

    // immutable: 읽기 전용
    val currencyList = listOf("달러", "유로", "원")

    // mutable: 추가 수정 삭제가 가능함
    val mutableCurrencyList = mutableListOf<String>().apply {  // apply를 통해 선언과 동시에 초기화 가능
        add("달러") // this의 add() 메서드를 사용
        add("유로")
        add("원")
    }
    mutableCurrencyList.add("파운드")

    // immutable set
    val numberSet = setOf(1, 2, 3, 4)

    // mutable set
    val mutableSet = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // immutable map
    val numberMap = mapOf("one" to 1, "tow" to 2) // 중위 표현식 to를 사용하여 key-value를 세팅할 수 있다.

    // mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1 // 자바에서처럼 put() 메서드로 값을 할당할 수도 있지만 코틀린에서는 리터럴 문법을 사용할 것을 추천한다.
    mutableNumberMap["two"] = 2
    mutableNumberMap["three"] = 3 // 자바스크립트에 익숙하다면 이 문법이 어색하지 않을 것이다.

    // 컬렉션 빌더는 내부에선 mutable 반환은 immutable
    val numberList: List<Int> = buildList {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    // linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    // arrayList
    val arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    val iterator = currencyList.iterator()

    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("==========================")

    for (currency in currencyList) {
        println(currency)
    }

    println("==========================")

    currencyList.forEach {
        println(it)
    }

    println("==========================")

    // for loop -> map
    val lowerList = listOf("a", "b", "c")
//    val upperList = mutableListOf<String>()

//    for (lowerCase in lowerList) {
//        upperList.add(lowerCase.uppercase())
//    }

    val upperList = lowerList.map { it.uppercase() } // for를 사용하기보다 인라인 함수를 사용하여 더 쉽게 작성할 수 있다.

    println(upperList)

    println("==========================")

    // for loop -> filter
//    val filteredList = mutableListOf<String>()
//    for (upperCase in upperList) {
//        if (upperCase == "A" || upperCase == "C") {
//            filteredList.add(upperCase)
//        }
//    }

    val filteredList = upperList.filter { it == "A" || it == "C" }
    println(filteredList)

    val filteredList2 = upperList.stream() // Java의 Stream API를 사용하는 방식
        .filter { it == "A" || it == "C" }
        .collect(Collectors.toList()) // 자바의 stream을 사용할 경우 중간 연산자의 결과를 최종 연사자까지 연결해주어야 된다.
    println(filteredList2)

    val filteredList3 = upperList
        .asSequence() // 코틀린은 시퀀스 API를 사용하여 최종 연산자를 사용하는 방식 (인라인 함수를 많이 사용하여 대량의 데이터를 다룰 경우 시퀀스 API를 사용하여 OOM(OutOfMemory)를 방지할 수 있다.)
        .filter { it == "A" || it == "C" }
        .filter { it == "C" }
        .filter { it == "C" }
        .filter { it == "C" }
        .filter { it == "C" }
        .toList() // terminal operator: (최종 연산자) 메모리에 대한 이슈를 해결할 수 있다.
    // WARN: 데이터가 많지 않은 경우에는 인라인 함수를 바로 사용하는 경우가 퍼포먼스가 더 좋다. (데이터가 많은 경우 시퀀스 API를 사용하는 것을 추천)
    println(filteredList3)
}