package mockito.bookservice

import booksevice.BookService
import booksevice.LendBookManager
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class BookServiceTest {

    @Test
    fun testLendIsCalled() {
        val bookService = Mockito.mock(BookService::class.java) // создал мок сервис
        `when`(bookService.inStock(100)).thenReturn(true) // законфигурировал на возврат true

        //создаем экземпляр объекта, который мы тестируем, и передаем туда мок
        val lendBookManager = LendBookManager(bookService)
        lendBookManager.checkout(100, 10)

        //после вызова бизнес логики класса "if(bookService.inStock(bookId))", который мы тестируем, БЛ работает правильно, вызывая потом функцию lang
        verify(bookService).lend(100, 10)
    }

    @Test
    fun testLendIsCalledEx() {
        val bookService = Mockito.mock(BookService::class.java) // создал мок сервис
        `when`(bookService.inStock(200)).thenReturn(false)

        val lendBookManager = LendBookManager(bookService)

        //после вызова бизнес логики класса "if(bookService.inStock(bookId))", который мы тестируем, БЛ работает правильно, вызывая потом ошибку

        val thrown = assertThrows<IllegalStateException> {
            lendBookManager.checkout(200,20)
//            "Book is not available"
        }
        assertEquals(thrown.message, "Book is not available")
    }

    @Test
    fun lendYes(){
        val mock = Mockito.mock(BookService::class.java)
        `when`(mock.inStock(100)).thenReturn(true)

        val lendBookManager = LendBookManager(mock)
        lendBookManager.checkout(100,10)

        verify(mock).lend(100,10)
    }

    @Test
    fun lendNo(){
        val mock = Mockito.mock(BookService::class.java)
        `when`(mock.inStock(200)).thenReturn(false)

        val lendBookManager = LendBookManager(mock)


        val thrown = assertThrows<IllegalStateException> {
            lendBookManager.checkout(200,20)
        }

        assertEquals(thrown.message, "Book is not available")
    }
}
