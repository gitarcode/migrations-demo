package co.gitar

import kotlin.test.Test
import org.junit.jupiter.api.Assertions.assertEquals

class Test {

    @Test
    fun testSimple() {
        val observable = flowOf("Hello World")
        val res = mutableListOf<String>()
        runBlocking { observable.collect { res += it } }
        assertEquals(listOf("Hello World"), res)
    }

    @Test
    fun testMBasic() {
        runBlocking {
            Streams.stream1()
                .map { it.first().code }
                .filter { it > 98 }
                .take(3)
                .collect { println(it) }
        }
    }

    @Test
    fun testZipWith() {
        val res = mutableListOf<String>()
        runBlocking {
            Streams.stream1().zip(Streams.stream2(), Streams::concat).collect { res += it }
        }
        assertEquals(listOf("ax", "by", "cz"), res)
    }

    @Test
    fun testStartWith() {
        val res = mutableListOf<String>()
        runBlocking {
            Streams.stream1().onStart { emitAll(Streams.stream2()) }.collect { res += it }
        }
        assertEquals(listOf("x", "y", "z", "a", "b", "c", "d", "e", "f"), res)
    }

    @Test
    fun testMergeWith() {
        val res = mutableListOf<String>()
        runBlocking { merge(Streams.stream1(), Streams.stream2()).collect { res += it } }
        assertEquals(listOf("a", "b", "c", "d", "e", "f", "x", "y", "z"), res)
    }

    @Test
    fun testFlatMap() {
        val res = mutableListOf<String>()
        runBlocking { Streams.stream1().flatMapConcat { Streams.stream2() }.collect { res += it } }
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
