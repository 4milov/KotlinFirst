import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FizzBuzzTest {
    @Test
    fun fizzBuzzTest(){
        assertEquals("4: ", fizzbuzz(4))
        assertEquals("3: Fizz", fizzbuzz(3))
        assertEquals("5: Buzz", fizzbuzz(5))
        assertEquals("15: FizzBuzz", fizzbuzz(15))
    }
}