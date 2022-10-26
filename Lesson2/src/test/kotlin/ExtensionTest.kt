import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test
import strings.allMatchesOf

class ExtensionTest {
    @Test
    fun testsExtensionFunction()
    {
        assertIterableEquals(
            listOf("<html>", "<head>"),
            "<html><head>hello".allMatchesOf("<[^>/]+>")
        )
    }
}