package org.test.tests.login;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.tests.BaseTest;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.test.pages.site.SiteOK.loginPage;
import static org.test.pages.site.SiteOK.mainPage;

public class LoginTest extends BaseTest {
    private static User user;
    private static String userFullName = "Иван Конев";
    private static String userLogin = "";
    private static String userPassword = "";

    @BeforeAll
    public static void init(){
        user = new User(userFullName, userLogin, userPassword);
    }

    @DisplayName("Test of login on ok.ru")
    @Test
    public void loginTest() {
        loginPage.loginForm.loginAs(user);
        assertEquals(mainPage.userFullName.getText(), user.getFullName(), "Попытка входа провалилась!");
    }
}
