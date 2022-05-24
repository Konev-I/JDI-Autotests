package org.test.tests.message;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.page.MessagePage;
import org.test.pages.wrappers.MessageWrapper;
import org.test.tests.BaseTest;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.test.pages.site.SiteOK.*;

public class MessageSendingTest extends BaseTest {
    private static User user;
    private static String userLogin = "";
    private static String userPassword = "";

    private String testChatName = "Спутник";

    @BeforeAll
    public static void init(){
        user = new User(userLogin, userPassword);
    }

    @DisplayName("Test of message sending")
    @ParameterizedTest
    @ValueSource(strings = {"test", "Hello!", "¯\\_(ツ)_/¯"})
    public void sendMessageTest(String message) {
        loginPage.loginForm.loginAs(user);

        mainPage.messagePageButton.click();
        messagePage.openChat(testChatName);
        messagePage.messageInputField.setValue(message);
        messagePage.sendButton.click();

        MessageWrapper lastSendMsg = messagePage.getLastSendMessage();
        assertEquals(lastSendMsg.getMessageText(), message, "Текст сообщения не совпадает с отправленным!");
    }

    @AfterEach
    public void end(){
        new MessagePage().getLastSendMessage().deleteMessage();
    }
}
