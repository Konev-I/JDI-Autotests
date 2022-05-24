package org.test.pages.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.test.utils.User;

public class LoginForm extends Form<User> {
    @UI("//*[contains(@name, 'st.email')]")
    private TextField login;

    @UI("//*[contains(@name, 'st.password')]")
    private TextField password;

    @UI("//*[contains(@class,'button-pro __wide')]")
    private Button loginButton;
}
