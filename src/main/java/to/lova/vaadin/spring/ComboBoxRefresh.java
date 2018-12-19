package to.lova.vaadin.spring;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;

@Route("combo-box-refresh")
public class ComboBoxRefresh extends VerticalLayout {

    public ComboBoxRefresh() {
        this.add(new H1("ComboBox refresh"));
        var list = new ArrayList<String>();
        list.add("Foo");
        list.add("Bar");
        var dp = DataProvider.<String, String>fromFilteringCallbacks(
                q -> list.stream().skip(q.getOffset()).limit(q.getLimit()),
                q -> list.size());
        var cb = new ComboBox<String>();
        cb.setDataProvider(dp);
        this.add(cb, new Button("Refresh", event -> {
            list.remove("Foo");
            dp.refreshAll();
        }));
    }

}
