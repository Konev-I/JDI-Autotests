package org.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.test.pages.site.SiteOK;
import org.test.utils.User;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static org.test.pages.site.SiteOK.loginPage;
import static org.test.pages.site.SiteOK.mainPage;

public abstract class BaseTest {
    @BeforeAll
    public static void initAll(){
        initElements(SiteOK.class);
    }

    @BeforeEach
    public void initBase() {
        loginPage.open();
    }

    @AfterEach
    public void endBase() {
        mainPage.logout();
    }
}
