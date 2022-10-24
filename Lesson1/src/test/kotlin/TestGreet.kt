import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestGreet {

    @Test
    fun greetSvetaIvanova()
    {
        assertEquals("Hello, Sveta Ivanova", greeting("Sveta", "Ivanova"))
    }
}