package org.test.tests.post;

import com.epam.jdi.light.elements.composite.WebPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.pages.wrappers.NewNote;
import org.test.pages.wrappers.NewNoteBuilder;
import org.test.tests.BaseTest;
import org.test.utils.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.test.pages.site.SiteOK.*;

public class NoteCreationTest extends BaseTest {
    private static User user;
    private static String userFullName = "Иван Конев";
    private static String userLogin = "";
    private static String userPassword = "";

    private String noteTestHeader = "Header";
    private String noteTestText = "Test";

    @BeforeAll
    public static void init(){
        user = new User(userFullName, userLogin, userPassword);
    }

    @DisplayName("Test of note creation")
    @Test
    public void makeNoteTest() {
        String checkString = noteTestHeader + "\n" + noteTestText;

        loginPage.loginForm.loginAs(user);

        NewNoteBuilder builder = NewNote.builder().addHeader(noteTestHeader).addText(noteTestText);
        mainPage.makeNote(builder.build());

        WebPage.refresh();

        Optional<FeedElemWrapper> note = mainPage.getLastFeedByUsername(user.getFullName());
        assertAll("note check",
                () -> assertTrue(note.isPresent(), "Не удалось найти пост!"),
                () -> assertEquals(checkString, note.get().getText(), "Текст не совпадает с отправленным через тест!"));
    }

    @AfterEach
    public void end(){
        mainPage.notePageButton.click();

        notesPage.optionListButton.click();
        notesPage.deleteButton.click();
    }
}
