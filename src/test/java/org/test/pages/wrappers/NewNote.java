package org.test.pages.wrappers;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class NewNote extends WebPage {
    private String header;
    private String text;
    private String quizQuestion;
    private ArrayList<String> answers;

    @UI("//span[contains(@class,'posting_itx_ac_menu')]")
    public Button moreOptionsButton;
    @UI("//div[contains(@data-action,'add_header')]")
    private Button headerAddButton;
    @UI("//textarea[contains(@data-id,'adHeader')]")
    private TextArea headerField;
    @UI("//div[contains(@class, 'ok-posting-handler')]")
    private TextArea textField;
    @UI("//div[contains(@data-l,'t,button.poll')]")
    private Button addQuizButton;
    @UI("//textarea[contains(@data-id,'question')]")
    private TextArea questionField;
    @UI("(//div[contains(@class,'js-poll-answers')]//div[contains(@class,'visible')])[1]//textarea")
    private TextArea answerFieldFirst;
    private By answerFieldLast = By.xpath("(//div[contains(@class,'js-poll-answers')]//div[contains(@class,'visible')])[last()]//textarea");
    @UI("//div[contains(@class, 'posting_submit')]")
    private Button submitButton;

    public NewNote(String header, String text, String quizQuestion, ArrayList<String> answers){
        this.header = header;
        this.text = text;
        this.quizQuestion = quizQuestion;
        this.answers = answers;
    }

    public static NewNoteBuilder builder(){
        return new NewNoteBuilder();
    }

    private void makeHeader(){
        moreOptionsButton.click();
        headerAddButton.click();
        headerField.setValue(header);
    }

    private void makeText(){
        textField.setValue(text);
    }

    private void makeQuiz(){
        addQuizButton.click();
        questionField.setValue(quizQuestion);
        answerFieldFirst.setValue(answers.get(0));

        UIElement answerFieldLastElem;
        for (int i = 1; i < answers.size(); i++){
            answerFieldLastElem = $(answerFieldLast);
            answerFieldLastElem.setValue(answers.get(i));
        }
    }

    public void send(){
        if (header != null){
            makeHeader();
        }

        if (text != null){
            makeText();
        }

        if (quizQuestion != null){
            makeQuiz();
        }

        submitButton.click();
        textField.shouldBe().notVisible();
    }
}
