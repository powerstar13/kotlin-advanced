import java.io.FileWriter

/**
 * @see Java_TryWithResources
 */
fun main() {

    // use 사용
    FileWriter("test.txt")
        .use {
            it.write("Hello Kotlin")
        }
}