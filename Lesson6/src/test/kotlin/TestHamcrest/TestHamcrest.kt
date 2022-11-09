import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.not
import org.junit.jupiter.api.Test

class TestHamcrest {

    @Test
    fun testHamcrest(){
        assertThat("hello", anything())
    }

    @Test
    fun testHamcrest2(){
        assertThat("hello", not("world"))
    }
    @Test
    fun testHamcrest3(){
        assertThat("hello", equals("hello"))
    }

}