package calculator

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // указывается для того, что бы для теста был создан только 1 экземпляр класса
class CalculatorTest {
    init {
        println("init")
    }

    @BeforeAll // перед всеми 1 раз
    fun prepare() {
        println("prepare")
    }

    @BeforeEach // перед каждым тестом
    fun prepareTest() {
        println("prepareTest")
    }

    @AfterAll
    fun tearDown() {
        println("tearDown")
    }

    @Test
    fun calcAdd() {
        println("calcAdd")
        val calculator = Calculator(15)
        calculator.add(2)
        assertEquals(17, calculator.get(), "15 + 2 should give 17")
    }

    @Test
    fun calcMul() {
        println("calcMul")
        val calculator = Calculator(25)
        calculator.mul(2)
        assertEquals(50, calculator.get(), "25 * 2 should give 50")
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource(
        "0, 1, 1", "10, 5, 15", "1, 100, 101"
    )
    fun paraAdd(f: Int, s: Int, r: Int) {
        println("paraAdd")
        val calculator = Calculator(f)
        calculator.add(s)
        assertEquals(r, calculator.get(), "$f + $s should give $r")
    }

    fun data(): Stream<Arguments> = Stream.of(
        Arguments.of(0, 0, 0), Arguments.of(0, 3, 0), Arguments.of(12, 6, 72), Arguments.of(3, 6, 18)
    )

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @MethodSource("data")
    fun paraMul(f: Int, s: Int, r: Int) {
        println("paraMul")
        val calculator = Calculator(f)
        calculator.mul(s)
        assertEquals(r, calculator.get(), "$f + $s should give $r")
    }

    @Test
    fun divisionByZeroThrowsException() {
        val calculator = Calculator(10)
        val exception = assertThrows<AssertionError> {
            calculator.div(0)
        }
        assertEquals("Division by zero", exception.message, "Exception should be : 'Division by zero' ")
    }

//    @Disabled //для отключения теста
    @Test
    fun combineAddAndMul() {
        val calculator = Calculator(15)

        assertAll("проверка сложения и умножения",
            {
                assertEquals(15, calculator.get())
            },
            {
                calculator.add(2)
                assertEquals(17, calculator.get())
            },
            {
                calculator.mul(3)
                assertEquals(51, calculator.get())
            }
        )
    }
}