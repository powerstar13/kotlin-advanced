//abstract class Developer {
sealed class Developer { // 실드 클래스는 하위 클래스를 제한 조건에 따라서 정의할 수 있다. 컴파일 시점에 확인할 수 있다. (굉장히 유연하고 안전하게 구현할 수 있다.)

    abstract val name: String
    abstract fun code(language: String)
}

data class BackendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 백엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 프런트엔드 개발자입니다. ${language}를 사용합니다.")
    }
}

data class AndroidDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 안드로이드 개발자입니다. ${language}를 사용합니다.")
    }
}

data class IosDeveloper(override val name: String) : Developer() {

    override fun code(language: String) {
        println("저는 IOS 개발자입니다. ${language}를 사용합니다.")
    }
}

object OtherDeveloper : Developer() {

    override val name: String = "익명"

    override fun code(language: String) {
        TODO("Not yet implemented")
    }

}

object DeveloperPool { // 싱글톤 객체

    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when (developer) {

        is BackendDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        is AndroidDeveloper -> pool[developer.name] = developer
        is IosDeveloper -> pool[developer.name] = developer
        is OtherDeveloper -> println("지원하지 않는 개발자입니다.")
//        else -> println("지원하지 않는 개발자입니다.") // absract일 경우 when식에서 else를 반드시 구현해주어야 한다. (WARN: else 코드는 버그를 유발할 수 있다...) (sealed 클래스인 경우 else가 없어도 된다.)
    }

    fun get(name: String) = pool[name]
}

fun main() {

    val backendDeveloper = BackendDeveloper(name = "토니")
    DeveloperPool.add(backendDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "카즈야")
    DeveloperPool.add(frontendDeveloper)

    val androidDeveloper = AndroidDeveloper(name = "안드로")
    DeveloperPool.add(androidDeveloper)

    val iosDeveloper = IosDeveloper(name = "애플")
    DeveloperPool.add(iosDeveloper)

    println(DeveloperPool.get("토니"))
    println(DeveloperPool.get("카즈야"))
    println(DeveloperPool.get("안드로"))
    println(DeveloperPool.get("애플"))
}