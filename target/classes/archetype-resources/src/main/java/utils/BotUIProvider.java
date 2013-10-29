package ${package}.utils;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

import ${package}.BotUI;

@SuppressWarnings("serial")
public class BotUIProvider extends UIProvider {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Class getUIClass(UIClassSelectionEvent event) {
        return BotUI.class;
    }

    @Override
    public UI createInstance(UICreateEvent event) {
    	UI instance = super.createInstance(event);
    	Injector.inject(instance);
    	return instance;
    }
}
