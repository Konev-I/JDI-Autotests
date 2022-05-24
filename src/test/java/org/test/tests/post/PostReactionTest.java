package org.test.tests.post;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.tests.BaseTest;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.test.pages.site.SiteOK.loginPage;
import static org.test.pages.site.SiteOK.mainPage;

public class PostReactionTest extends BaseTest {
    private static User user;
    private static String userLogin = "";
    private static String userPassword = "";

    @BeforeAll
    public static void init(){
        user = new User(userLogin, userPassword);
    }

    @DisplayName("Test of setting reaction on post")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void reactionTest(int numOfReaction) {
        loginPage.loginForm.loginAs(user);

        FeedElemWrapper post = mainPage.getFeedList().get(0);
        String selectedReactionName = post.setReaction(numOfReaction);
        assertEquals(selectedReactionName, post.getReactionName(), "Установлена не та реакция, которую мы выбирали");
    }
}
