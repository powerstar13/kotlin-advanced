class HelloBot {

//    var greeting: String? = null
    val greeting: String by lazy { // greeting 변수를 사용하는 시점에 lazy가 동작하게 되면서 getHello 메서드에 의해 초기화된다. (by lazy를 사용하려면 불변 변수(val)를 사용해야 한다.)
//    val greeting: String by lazy(LazyThreadSafetyMode.NONE) { // 멀티-스레드 환경이 아닌 경우에는 NONE으로 설정하고 사용해도 된다.
//    val greeting: String by lazy(LazyThreadSafetyMode.PUBLICATION) { // 멀티-스레드 환경이어도 동기화가 필요하지 않은 경우에는 PUBLICATION으로 설정해도 된다.
        getHello()
    }

    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {

    val helloBot = HelloBot()

    // ...

//    helloBot.greeting = getHello() // 지연 할당
//    helloBot.sayHello()
//    helloBot.sayHello()
//    helloBot.sayHello()

    for (i in 1 .. 5) {
        Thread { // lazy는 멀티-스레드 환경에서도 안전하게 동작할 수 있다.
            helloBot.sayHello()
        }.start()
    }
}