class DatabaseClient {

    var url: String? = null
    var username: String? = null
    var password: String? = null

    /**
     * DB에 접속하고 Boolean 결과를 반환
     */
    fun connect() : Boolean {

        println("DB 접속 중...")
        Thread.sleep(1000)
        println("DB 접속 완료")

        return true
    }
}

fun main() {

//    val config = DatabaseClient()
//    config.url = "localhost:3306"
//    config.username = "mysql"
//    config.password = "1234"
//
//    val connected = config.connect()

    // 참조에 대한 중복 코드 없이 run을 사용하여 프로퍼티에 값을 바로 할당하고 로직에 대한 값을 반환할 수 있다.
    val connected: Boolean = DatabaseClient().run {
        // this 키워드를 생략하고 사용할 수 있다.
        url = "localhost:3306"
        username = "mysql"
        password = "1234"

        connect()
    }

    println(connected)

    // let을 사용해도 되지만 it에 대한 중복 코드가 발생하기 때문에 run을 사용하는 것이 효율적이다.
//    val connected2 = DatabaseClient().let {
//
//        it.url = "localhost:3306"
//        it.username = "mysql"
//        it.password = "1234"
//
//        it.connect()
//    }

    println("----------------")

    val result = with(DatabaseClient()) {

        url = "localhost:3306"
        username = "mysql"
        password = "1234"

        connect()
    }
    println(result)
}