package to.lova.vaadin.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("combo-box-with-dialog")
public class ComboBoxWithDialog extends VerticalLayout {

    public ComboBoxWithDialog() {
        this.add(new H1("ComboBox with dialog"));
        var dialog = new ConfirmDialog();
        dialog.add(
                new Paragraph(
                        "Think of a grid for advance filtering/selection."),
                new Paragraph(
                        "Now press ESC and try to select a ComboBox item!"));
        var button = new Button("Grid", event -> dialog.open());
        button.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        var buttonElement = button.getElement();
        buttonElement.setAttribute("slot", "prefix");
        var comboBox = new ComboBox<String>();
        comboBox.setItems("Hydrogen", "Helium", "Lithium");
        comboBox.getElement().appendChild(buttonElement);
        this.add(comboBox);
    }

}
