package mockito

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.Captor
import org.mockito.Mockito.*
import java.util.*

class TestingMockito {

    @Test
    fun test1() {
        val test: MyClass = mock(MyClass::class.java)
        `when`(test.getUniqueId()).thenReturn(43)
        assertEquals(43, test.getUniqueId())

    }

    @Test
    fun testTwoReturnValues() {
        val iter = mock(Iterator::class.java) as Iterator<String>
        `when`(iter.next()).thenReturn("Hello").thenReturn("World")
        val result = iter.next() + " " + iter.next()
        assertEquals("Hello World", result)
    }

    @Test
    fun testComparable() {
        val comparable = mock(Comparable::class.java) as Comparable<String>
        `when`(comparable.compareTo("Hello")).thenReturn(2)
        `when`(comparable.compareTo("World")).thenReturn(4)
        assertEquals(2, comparable.compareTo("Hello"))
        assertEquals(4, comparable.compareTo("World"))
    }

    @Test
    fun testThrows() {
        val props = mock(Properties::class.java)
        `when`(props["Linux"]).thenReturn("OK")
        `when`(props["Anddddroid"]).thenThrow(java.lang.IllegalArgumentException("Typo"))
        assertEquals("OK", props["Linux"])
        val thrown = assertThrows<IllegalArgumentException> {
            props["Anddddroid"]
        }
        assertEquals(thrown.message, "Typo")
    }

    fun testSpyWrong() { //spy обертка на реальным объектом // mock шаблон класса без заданного поведения
        val list: List<String> = LinkedList()
        val spy: List<String> = spy(list)
//        `when`(spy[0]).thenReturn("hello") // возврат того чего нет
        doReturn("hello").`when`(spy[0]) //потому сначала задаем поведение, а потом его возвращаем
        assertEquals(spy[0], "hello")
    }

    @Test
    fun testVerify(){
        val test = mock(MyClass::class.java)
        `when`(test.getUniqueId()).thenReturn(43)

        //! Создаем переменную хранящую порядок
        val inOrder = inOrder(test)

        test.testing(12)
        test.getUniqueId()
        test.getUniqueId()

        verify(test).testing(ArgumentMatchers.eq(12)) // для mock тест вызывалась функция testing и вызывалась с параметром 12
        verify(test, times(2)).getUniqueId() // ф-я getUniqueId() вызывалась 2 раза
        verify(test, atLeastOnce()).getUniqueId() // ф-я getUniqueId() вызывалась хотя бы раз
        verify(test, atLeast(1)).getUniqueId() // ф-я getUniqueId() вызывалась хотя бы раз
        verify(test, atMost(10)).getUniqueId()// ф-я getUniqueId() вызывалась не более 10 раз
        verify(test, never()).someMethod("never called") // someMethod никогда не вызывался

        //! Проверяем порядок вызова методов
        inOrder.verify(test).testing(12)
        inOrder.verify(test, times(2)).getUniqueId()

        verifyNoMoreInteractions(test) // больше ничего не вызывалось

    }

    @Captor
    lateinit var stringCaptor: ArgumentCaptor<String>

    class MockitoHelper{
        fun <T> capture(captor: ArgumentCaptor<T>) : T = captor.capture()
    }

    @Test
    fun shouldContainString(){
        stringCaptor = ArgumentCaptor.forClass(String::class.java) // тип String::class.java показывает какого рода арнументы мы будем запускать

        val helper = MockitoHelper()

        var list = LinkedList<String>()
        val spy = spy(list)
        spy.add("hello")
//        verify(spy).add(stringCaptor.capture()) //IllegalStateException
        verify (spy).add(helper.capture(stringCaptor))
        assertTrue(stringCaptor.value == "hello")

    }


}