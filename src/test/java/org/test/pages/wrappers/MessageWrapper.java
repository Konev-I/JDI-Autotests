package org.test.pages.wrappers;

import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class MessageWrapper {
    private UIElement message;
    private By msgText = By.xpath(".//msg-parsed-text");
    private By optionsButton = By.xpath(".//msg-button[contains(@data-l,'t,messageActionmore')]");
    private By deleteButton = By.xpath("//msg-menu-item[contains(@data-l, 't,messageActionremove')]");
    private By confirmDeleteButton = By.xpath("//msg-button[contains(@data-tsid,'confirm-primary')]");

    public MessageWrapper(UIElement message){
        this.message = message;
    }

    public String getMessageText(){
        UIElement msgTextElem = message.find(msgText);
        return msgTextElem.getText();
    }

    public void deleteMessage(){
        message.click();

        UIElement optionsButtonElem = message.find(optionsButton);
        optionsButtonElem.click();

        UIElement deleteButtonElem = $(deleteButton);
        deleteButtonElem.click();

        UIElement confirmDeleteButtonElem = $(confirmDeleteButton);
        confirmDeleteButtonElem.click();
    }
}
