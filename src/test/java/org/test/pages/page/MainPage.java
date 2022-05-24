package org.test.pages.page;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.By;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.pages.wrappers.NewNote;

import java.util.ArrayList;
import java.util.Optional;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class MainPage{
    @UI("//*[contains(@class, 'tico ellip')]")
    public Text userFullName;

    @UI("//div[contains(@data-module,'ToolbarManager')]//li[contains(@data-l,'t,messages')]")
    public Button messagePageButton;

    @UI("//div[contains(@class,'js-toolbar-menu')]")
    public Button userImageButton;

    @UI("//a[contains(@data-l,'t,logout')]")
    public Button logoutButton;

    @UI("//input[contains(@data-l,'t,logout')]")
    public Button confirmLogoutButton;

    @UI("//a[contains(@class, 'pf-head_itx_a')]")
    public Button textNoteStarter;

    public By feedElems = By.xpath("//div[contains(@class, 'feed-w')]");

    @UI("//a[contains(@data-l,'t,userStatuses')]")
    public Button notePageButton;

    public void logout(){
        userImageButton.click();
        logoutButton.click();
        confirmLogoutButton.click();
    }

    public MainPage makeNote(NewNote note){
        textNoteStarter.click();
        note.send();
        return this;
    }

    public ArrayList<FeedElemWrapper> getFeedList() {
        ArrayList<FeedElemWrapper> feedList = new ArrayList<>();
        for (UIElement elem : $$(feedElems)) {
            feedList.add(new FeedElemWrapper(elem));
        }
        return feedList;
    }

    public Optional<FeedElemWrapper> getLastFeedByUsername(String username){
        for (FeedElemWrapper elem: getFeedList()){
            if (elem.isByUser() && elem.getAuthor().equals(username)){
                return Optional.of(elem);
            }
        }
        return Optional.empty();
    }
}
