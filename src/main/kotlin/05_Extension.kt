fun String.first() : Char { // 클래스.함수명 으로 확장 함수를 작성
    return this[0] // "ABCD"가 this가 된다.
}

fun String.addFirst(char: Char) : String {
    return char + this
}

class MyExample {

    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 출력") // 확장 함수명이 이미 클래스에 동일한 함수명이라면 클래스의 함수가 우선이다.

fun MyExample.printMessage(message: String) = println(message) // 함수명이 같더라도 인자가 다르면 오버로드가 적용된다.

fun MyExample?.printNullOrNotNull() {
    if (this == null) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main() {

    println("ABCD".first())

    println("ABCD".addFirst('Z'))

    MyExample().printMessage()

    MyExample().printMessage("확장 출력")

    var myExample: MyExample? = null // nullable 타입으로 선언되어도 MyExample 함수는 null 체크를 내부에서 이미 했기 때문에 사용할 때 안전 연산자가 필요 없다.
    myExample.printNullOrNotNull()

    myExample = MyExample()
    myExample.printNullOrNotNull()
}