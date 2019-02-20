package to.lova.vaadin.spring;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("flow/5092")
public class KeyUpListenerError extends VerticalLayout {

    public KeyUpListenerError() {
        var textField = new TextField();
        var textInput = new Input().getElement();
        textInput.setAttribute("slot", "input");
        textField.getElement().appendChild(textInput);
        textField.addKeyUpListener(Key.ENTER,
                event -> Notification.show("Key.ENTER Pressed!"));

        var passwordField = new PasswordField();
        var passwordInput = new Input().getElement();
        passwordInput.setAttribute("slot", "input");
        passwordField.getElement().appendChild(passwordInput);
        passwordField.addKeyUpListener(Key.ENTER,
                event -> Notification.show("Key.ENTER Pressed!"));

        add(textField, passwordField);
    }

}
