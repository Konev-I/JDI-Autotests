package org.test.pages.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import org.test.pages.page.LoginPage;
import org.test.pages.page.MainPage;
import org.test.pages.page.MessagePage;
import org.test.pages.page.NotesPage;

@JSite("https://ok.ru")
public class SiteOK {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static MessagePage messagePage;
    public static NotesPage notesPage;
}
