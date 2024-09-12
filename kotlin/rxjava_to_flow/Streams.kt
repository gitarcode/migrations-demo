package co.gitar

import io.reactivex.rxjava3.core.Observable

object Streams {
    fun stream1(): Observable<String> {
        return Observable.just("a", "b", "c", "d", "e", "f")
    }

    fun stream2(): Observable<String> {
        return Observable.fromIterable(listOf("x", "y", "z"))
    }

    fun stream3(): Observable<String> {
        return Observable.fromCallable { call() }
            .delay(10, TimeUnit.MILLISECONDS)
    }

    private fun call(): String {
        return "s"
    }

    fun concat(s1: String, s2: String): String {
        return s1 + s2
    }
}
