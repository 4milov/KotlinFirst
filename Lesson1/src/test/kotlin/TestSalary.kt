import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestSalary {
    @Test
    fun testJapaneseSalary(){
        assertEquals(150_000.toBigDecimal(), japaneseSalary(years = 10))
    }

    @Test
    fun testNegativeJapaneseSalary()
    {
        val thrown = assertThrows<IllegalArgumentException>
        {
            japaneseSalary((-10).toBigDecimal(), 12)
        }
        // thrown.message
        assertEquals("Base salary can't be negative", thrown.message)
    }
}