package coroutines

import kotlinx.coroutines.*
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

/**  * Chap01
 *
 * @author incheol.jung
 * @since 2020. 12. 27.
 */
fun sumAll(){
    runBlocking {
        val d1 = async { delay(1000L); 1}
        log("after async(d1)")
        val d2 = async { delay(1000L); 2}
        log("after async(d2)")
        val d3 = async { delay(1000L); 3}
        log("after async(d3)")

        log("1+2+3 =${d1.await() + d2.await() + d3.await()}")
        log("after await all & add")
    }
}

fun main() {
    sumAll()
}