package org.test.pages.page;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class NotesPage extends WebPage {
    @UI("//span[contains(@class,'new_topic_icodown')]")
    public Button optionListButton;
    @UI("(//div[contains(@id,'hook_Block_ShortcutMenu')]//a[contains(@class,'u-menu')])[last()]")
    public Button deleteButton;
}
