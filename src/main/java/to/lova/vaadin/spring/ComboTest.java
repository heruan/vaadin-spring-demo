package to.lova.vaadin.spring;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route("combo-box-connector-error")
@Tag("combo-test")
@HtmlImport("combo-test.html")
public class ComboTest extends PolymerTemplate<TemplateModel>
        implements HasComponents {

    @Id("tabs")
    protected Tabs tabs;

    public ComboTest() {
        var cb = new ComboBox<String>();
        cb.setItems("Foo", "Bar");
        var binder = new Binder<Bean>();
        binder.forField(cb).asRequired().bind(Bean::getter, Bean::setter);
        this.add(cb);
        this.tabs.add(new Tab("Foo"));
    }

    interface Bean {
        String getter();

        void setter(String value);
    }
}
