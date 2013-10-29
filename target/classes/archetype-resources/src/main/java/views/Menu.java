package ${package}.views;

import java.util.HashMap;

import com.vaadin.server.Resource;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@SuppressWarnings ( "serial" )
public class Menu extends VerticalLayout {

    private Accordion menuContainer = new Accordion();
    private HashMap<String, Tab> tabContainer = new HashMap<>();
    
    public Menu() {
        setHeight(100, Unit.PERCENTAGE);
        setWidth(100, Unit.PERCENTAGE);
        setMargin( true );
        setSpacing( true );
        menuContainer.setStyleName(Reindeer.TABSHEET_MINIMAL);
        addComponent(menuContainer);
    }
    
    public void addTab(Component c, String caption, Resource icon) {
    	Tab tab = menuContainer.addTab(c, caption, icon);
    	tabContainer.put(caption, tab);
    }
    
    public void removeTab(String name) {
    	menuContainer.removeTab(tabContainer.get(name));
    	tabContainer.remove(name);
    }
    
    public Accordion getMenuContainer() {
        return this.menuContainer;
    }
}
