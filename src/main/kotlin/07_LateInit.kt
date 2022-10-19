class `07_LateInit` {

    lateinit var text: String // lateinit은 가변 프로퍼티에 대해서 non-null 타입인 경우에 사용할 수 있다.

    val textInitialized: Boolean
        get() = this::text.isInitialized

    fun printText() {
//        println(text) // 초기화가 되지 않은 값을 사용하려고 할 경우 UninitializedPropertyAccessException: lateinit property text has not been initialized 에러를 만나게 된다.
        if (textInitialized) {
            println("초기화됨")
        } else {
            text = "안녕하세요"
        }
        println(text)
    }
}

fun main() {

    val test = `07_LateInit`()

    if (!test.textInitialized) {
        test.text = "하이요"
    }
    test.printText()
}