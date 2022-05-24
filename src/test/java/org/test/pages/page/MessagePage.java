package org.test.pages.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.By;
import org.test.pages.wrappers.MessageWrapper;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class MessagePage extends WebPage {
    @UI("//input[contains(@name,'chat-search')]")
    public TextField searchUserField;

    @UI("//msg-input")
    public TextField messageInputField;

    @UI("//msg-button[contains(@data-tsid,'button_send')]")
    public Button sendButton;

    private By lastSendMessage = By.xpath("(//msg-message[@mine])[last()]");

    public void openChat(String chatName){
        searchUserField.setValue(chatName);
        UIElement chatElem = $(By.xpath("//msg-search-results-item[//span[text() = '"+chatName+"']]"));
        chatElem.click();
    }

    public MessageWrapper getLastSendMessage(){
        UIElement messageElem = $(lastSendMessage);
        return new MessageWrapper(messageElem);
    }
}
