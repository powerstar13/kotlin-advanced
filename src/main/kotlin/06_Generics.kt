class MyGenerics<out T>(val t: T) { // 공변성이 필요한 경우에 타입 파라미터에 out 키워드를 사용한다.

}

class Bag<T> {

    fun saveAll(
        to: MutableList<in T>, // 반공변성이 필요한 경우에 in 키워드를 통해 해결
        from: MutableList<T>,
    ) {
        to.addAll(from)
    }
}

fun main() {
    // 제네릭을 사용한 클래스의 인스턴스를 만들려면 타입 아규먼트를 제공
    val generics = MyGenerics<String>("테스트")

    // 생략 가능
    val generics2 = MyGenerics("테스트") // 생성자에서 String임을 추론할 수 있기 때문에 타입 아규먼트를 생략할 수 있다.

    // 변수의 타입에 제네릭을 사용한 경우
    val list1: MutableList<String> = mutableListOf()
    // 타입 아규먼트를 생성자에서 추가
    var list2 = mutableListOf<String>()

    // 스타 프로젝션 문법을 사용하여 어떤 값이 들어올지 모르지만 안전하게 사용
    val list3: List<*> = listOf<String>("테스트")
    val list4: List<*> = listOf<Int>(1, 2, 3, 4)

    // 변성: 제네릭에서 파라미터가 서로 어떤 관계에 있는지 설명하는 개념
    // PECS(Producer-Extends, Consumer-Super)

    // 공변성은 자바 제네릭의 extends 코틀린에선 out
    val charGenerics: MyGenerics<CharSequence> = generics
    // 반공변성은 자바 제네릭의 super 코틀린에선 in
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))
}