package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

/**  * Chap01
* 
* @author incheol.jung
* @since 2020. 12. 27. 
*/
fun now() = ZonedDateTime.now().toLocalDateTime().truncatedTo(ChronoUnit.MILLIS)
fun log(msg:String) = println("${now()}:${Thread.currentThread()}:${msg}")
fun launchInGlobalScope() {
    runBlocking {
        launch {
            log("GlobalScope.launch started.")
        }
    }
}

fun main() {
    log("main() started.")
    launchInGlobalScope()
    log("launchInGlobalScope() executed")
//    Thread.sleep(5000L)
    log("main() terminated")
}