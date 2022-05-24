package org.test.pages.wrappers;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class FeedElemWrapper {
    private UIElement element;
    private By feedAuthor = By.xpath(".//a[contains(@class, 'user-link o')]");
    private By feedGroup = By.xpath(".//a[contains(@class, 'group-link o')]");
    private By feedText = By.xpath(".//div[contains(@class, 'media-text_cnt_tx')]");

    private By reactionButton = By.xpath(".//span[contains(@class,'js-klass-action')]");
    private By reactionsTypeButtons = By.xpath("//span[@data-reaction-id]");
    private String reactionName = "data-reaction-text";
    private By selectReactText = By.xpath(".//span[contains(@class,'widget_tx')]");

    public FeedElemWrapper(UIElement elem){
        this.element = elem;
    }

    public boolean isByUser(){
        return element.find(feedAuthor).isDisplayed();
    }

    public boolean isByGroup(){
        return element.find(feedGroup).isDisplayed();
    }

    public String getAuthor(){
        UIElement feedAuthorElem = element.find(feedAuthor);
        return feedAuthorElem.getText();
    }

    public String getText(){
        UIElement feedTextElem = element.find(feedText);
        return feedTextElem.getText();
    }

    public String setReaction(int numOfReaction){
        UIElement reactionButtonElem = element.find(reactionButton);
        reactionButtonElem.hover();
        WebList reactionsTypeButtonsElems = $$(reactionsTypeButtons);
        UIElement react = reactionsTypeButtonsElems.get(numOfReaction);
        String reactName = react.getAttribute(reactionName);
        react.click();

        return reactName;
    }

    public String getReactionName(){
        UIElement reactionButtonElem = element.find(reactionButton);
        UIElement selectReactTextElem = reactionButtonElem.find(selectReactText);
        return selectReactTextElem.getText();
    }
}
