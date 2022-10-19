data class Person(val name: String, val age: Int) // data 클래스

fun main() {

    // equals
    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name = "tony", age = 12)

    println(person1 == person2)

    // hashCode
    val set = hashSetOf(person1)
    println(set.contains(person2))

    // toString
    println(person1.toString())

    // copy를 사용하면 객체의 불변성을 쉽게 유지할 수 있다.
    // WARN 1: 불변성이 깨진 경우 hash 계열에 문제가 생긴다.
    // WARN 2: 가변 변수는 멀티-스레드 환경에서 문제가 생긴다.
    val person3 = person1.copy(name = "strange")
    println(person3)

    // componentN (N은 프로퍼티의 개수와 동일하며 순서대로 가져올 수 있다.)
    println("이름: ${person1.component1()}, 나이: ${person1.component2()}")
    // 구조분해할당을 통해 더 쉽게 가져올 수 있다.
    val (name, age) = person1
    println("이름: $name, 나이: $age")
}