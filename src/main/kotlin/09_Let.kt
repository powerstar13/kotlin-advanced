fun main() {

    val str: String? = "안녕"

    val result: Int? = str?.let { // let은 null이 아닌 경우에 로직을 작성한다.
        println(it) // 안녕

        val abc: String? = "abc"
        val def: String? = "def"

        // let을 중첩하여 내부에서 작성하기 보다는 if를 사용하는 것이 가독성이 좋다.
        if (!abc.isNullOrEmpty() && !def.isNullOrEmpty()) println("abcdef가 null이 아님")

        1234 // return을 작성하지 않아도 값이 반환된다.
    }

    println(result) // 1234

//    val this: String? = null // Expecting property name or receiver type
//    val it: String? = null // it은 소프트 키워드여서 변수명으로 만들 수 있다.

    val hello = "hello"
    val hi = "hi"

    // let이 중첩되어 사용될 경우 it의 변수명을 명시하여 사용하는 것이 가독성에 좋다.
    hello.let { a ->

        hi.let { b ->
            println(a.length)
            println(b.length)
        }
    }
}