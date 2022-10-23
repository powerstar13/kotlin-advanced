fun getStr(): Nothing = throw Exception("예외 발생 기본값으로 초기화")

fun main() {

    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message) // 예외 발생 기본값으로 초기화
        "기본값"
    }

    println(result) // 기본값

    println("----------------")

    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message) // 예외 발생 기본값으로 초기화
            "기본값"
        }

    println(result2) // 기본값

    println("----------------")

    val result3: Nothing? = runCatching { getStr() }
        .getOrNull() // 실패인 경우 null을 반환

    println(result3) // null

    val result4 = runCatching { "성공" }
        .getOrNull()

    println(result4) // 성공

    println("----------------")

    val result5: Throwable? = runCatching { getStr() }
        .exceptionOrNull() // Exception인 경우 결과를 반환

    result5?.let {
        println(it.message) // 예외 발생 기본값으로 초기화
//        throw it
    }

    println("----------------")

    val result6 = runCatching { getStr() }
        .getOrDefault("기본값")

    println(result6) // 기본값

    println("----------------")

//    val result7: Nothing = runCatching { getStr() }
//        .getOrThrow()

    val result8: String = runCatching { "성공" }
        .getOrThrow() // 기본값


    println("----------------")

    val result9 = runCatching { "안녕" }
        .map {
            "${it}하세요"
        }
        .getOrThrow()

    println(result9) // 안녕하세요

    val result10 = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예외")
        }
        .getOrDefault("기본값")

    println(result10) // 기본값


    println("----------------")

    val result11 = runCatching { "성공" }
        .recover { "복구" }
        .getOrNull()

    println(result11) // 성공

    val result12 = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()

    println(result12) // 복구

    val result13 = runCatching { getStr() }
        .recoverCatching {
            throw Exception("예외")
        }
        .getOrDefault("복구")

    println(result13) // 복구
}