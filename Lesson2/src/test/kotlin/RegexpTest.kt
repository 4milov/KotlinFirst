import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RegexpTest {
    @Test
    fun regexpTest(){
        assertTrue(date("12 FEB 2020"))
        assertFalse(date("12 ZZZ 2020"))
    }
}