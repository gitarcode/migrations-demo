package co.gitar

object Streams {
    fun stream1(): Flow<String> {
        return flowOf("a", "b", "c", "d", "e", "f")
    }

    fun stream2(): Flow<String> {
        return flowOf("x", "y", "z")
    }

    fun stream3(): Flow<String> {
        return flow {
            delay(10)
            emit(call())
        }
    }

    private fun call(): String {
        return "s"
    }

    fun concat(s1: String, s2: String): String {
        return s1 + s2
    }
}
