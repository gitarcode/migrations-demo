package co.gitar

import co.gitar.Streams
import io.reactivex.rxjava3.core.Observable
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals

class Test {

    @Test
    fun testSimple() {
        val observable = Observable.just("Hello World")
        val res = mutableListOf<String>()
        observable.subscribe { res += it }
        assertEquals(listOf("Hello World"), res)
    }

    @Test
    fun testMBasic() {
        Streams.stream1().map { it.first().code }
            .filter { it > 98 }
            .take(3)
            .subscribe { println(it) }
    }

    @Test
    fun testZipWith() {
        val res = mutableListOf<String>()
        Streams.stream1().zipWith(Streams.stream2(), Streams::concat).subscribe { res += it }
        assertEquals(listOf("ax", "by", "cz"), res)
    }

    @Test
    fun testStartWith() {
        val res = mutableListOf<String>()
        Streams.stream1()
            .startWith(Streams.stream2())
            .subscribe { res += it }
        assertEquals(listOf("x", "y", "z", "a", "b", "c", "d", "e", "f"), res)
    }

    @Test
    fun testMergeWith() {
        val res = mutableListOf<String>()
        Streams.stream1().mergeWith(Streams.stream2()).subscribe { res += it }
        assertEquals(listOf("a", "b", "c", "d", "e", "f", "x", "y", "z"), res)
    }

    @Test
    fun testFlatMap() {
        val res = mutableListOf<String>()
        Streams.stream1().flatMap { Streams.stream2() }.subscribe { res += it }
        assertEquals(
            listOf(
                "x",
                "y",
                "z",
                "x",
                "y",
                "z",
                "x",
                "y",
                "z",
                "x",
                "y",
                "z",
                "x",
                "y",
                "z",
                "x",
                "y",
                "z"
            ),
            res
        )
    }
}
