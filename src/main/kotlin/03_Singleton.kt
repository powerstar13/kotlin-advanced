import java.time.LocalDateTime

object Singleton { // object 키워드를 사용하는 것만으로 싱글톤 객체를 쉽게 만들 수 있다. (이 객체를 사용해서 Util 클래스를 많이 만든다.)

    val a = 1234

    fun printA() = println(a)
}

object DatetimeUtils {

    val now: LocalDateTime
        get() = LocalDateTime.now()

    const val DEFAULT_FORMAT = "YYYY-MM-DD" // const는 자바의 상수와 유사하다고 보면 된다.

    fun same(a: LocalDateTime, b: LocalDateTime) : Boolean {
        return a == b
    }
}

class MyClass private constructor() {

    //    companion object { // companion object 키워드를 사용해서 동반 객체를 만들 수 있다.
    companion object MyCompanion { // 이름을 붙일 수도 있다.

        val a = 1234

        fun newInstance() = MyClass()
    }
}

fun main() {
    // singleton
    println(Singleton.a)
    Singleton.printA()

    println("--------------------")

    // util 클래스 사용하기
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)
    println(DatetimeUtils.now)

    println(DatetimeUtils.DEFAULT_FORMAT)

    val now = LocalDateTime.now()
    println(DatetimeUtils.same(now, now))

    println("--------------------")

    // 동반 객체
    println(MyClass.a)
    println(MyClass.newInstance())

    // .Companion은 생략 가능함
//    println(MyClass.Companion.a)
//    println(MyClass.Companion.newInstance())
    println(MyClass.MyCompanion.a)
    println(MyClass.MyCompanion.newInstance())
}