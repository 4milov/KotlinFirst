package mockito.mail

import mail.Client
import mail.Mailer
import mail.PersonalInfo
import mail.sendMessageToClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

class MailTest {

    @Test
    fun mailTest() {

        val mailer = Mockito.mock(Mailer::class.java)


        val personalInfo = PersonalInfo("mail.ru")
        val client = Client(personalInfo)
        val message = "Hi there"

        sendMessageToClient(client, message, mailer)

        verify(mailer).sendMessage("mail.ru", "Hi there")
    }

    @Test
    fun mailTestFalse() {

        val mailer = Mockito.mock(Mailer::class.java)


        val personalInfo = PersonalInfo(null)
        val client = Client(personalInfo)
        val message = "Hi there"

        sendMessageToClient(client, message, mailer)

//        verify(mailer, never()).sendMessage("mail.ru", "Hi there")
        verifyNoMoreInteractions(mailer)
    }


}