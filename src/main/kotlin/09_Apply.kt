fun main() {

    val client: DatabaseClient = DatabaseClient().apply { // apply는 프로퍼티를 내부 로직에서 초기화하여 컨텍스트를 그대로 반환할 때 사용한다.
        // this 키워드를 생략하고 사용할 수 있다.
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }

    client.connect().run { println(this) }

    println("---------------------")

    // 체이닝 형태로도 작성 가능
    DatabaseClient().apply {
        // this 키워드를 생략하고 사용할 수 있다.
        url = "localhost:3306"
        username = "mysql"
        password = "1234"
    }.connect()
        .run { println(this) }
}