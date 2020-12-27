package coroutines

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

/**  * Chap01
 *
 * @author incheol.jung
 * @since 2020. 12. 27.
 */
fun main() {
    runBlocking {
        launch { // 부모 컨텍스트를 사용(이 경우 main)
            println("main runBlocking : I'm working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) { // 특정 스레드에 종속되지 않음 ? 메인 스레드 사용
            println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) { // 기본 디스패처를 사용
            println("Default : I'm working in thread ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyOwnThread")) { // 새 스레드를 사용
            println("newSingleThreadContext : I'm working in thread ${Thread.currentThread().name}")
        }
    }
}