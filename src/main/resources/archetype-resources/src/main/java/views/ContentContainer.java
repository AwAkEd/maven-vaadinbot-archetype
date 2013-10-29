package ${package}.views;

import java.util.HashMap;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;

import ${package}.utils.Images;
import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class ContentContainer extends TabSheet {

    private HashMap<String, Tab> tabContainer = new HashMap<String, Tab>();

    public ContentContainer() {
    	setSizeFull();
    	setStyleName(Reindeer.TABSHEET_MINIMAL);
    	addStyleName(Reindeer.TABSHEET_SELECTED_CLOSABLE);
    	setCloseHandler(new TabCloseHandler());
    	Tab welcomeTab = addTab(new WelcomeTab(), WelcomeTab.CAPTION, Images.getImage("bot.home.icon"));
    	welcomeTab.setClosable(false);
    }

    public void addManagementTab(Component c, String caption, Resource icon) {
    	Tab tab = addTab(c, caption, icon);
    	tab.setClosable(true);
    	tabContainer.put(caption, tab);
    }

    public void removeTab(String name) {
    	Tab tab = tabContainer.get(name);
    	int position = getTabPosition(tab);
    	removeTab(tab);
    	if (position == getComponentCount() + 1) {
    	    setSelectedTab(getComponentCount());
    	} else {
    	    setSelectedTab(position);
    	}
    	tabContainer.remove(name);
    }

    public Tab findTab(String name) {
    	for (String key : tabContainer.keySet()) {
    	    if (key.equals(name)) {
    		return tabContainer.get(key);
    	    }
    	}
    	return null;
    }

    public String findTabName(Component tab) {
    	for (String key : tabContainer.keySet()) {
    	    if (tab.equals(tabContainer.get(key).getComponent())) {
    		return key;
    	    }
    	}
    	return "";
    }

    class TabCloseHandler implements CloseHandler {
    	public TabCloseHandler() {
    	}
    
    	@Override
    	public void onTabClose(TabSheet tabsheet, Component tabContent) {
    	    final String tabName = findTabName(tabContent);
    	    final Window confirm = new Window(Messages.getMessage("bot.window.confirm.caption"));
    	    confirm.setStyleName(Reindeer.WINDOW_BLACK);
    	    confirm.setSizeUndefined();
    	    confirm.setClosable(false);
    	    confirm.setDraggable(false);
    	    confirm.setModal(true);
    	    confirm.setResizable(false);
    	    confirm.center();
    
    	    VerticalLayout content = new VerticalLayout();
    	    content.setSizeUndefined();
    	    content.setMargin(true);
    	    content.setSpacing(true);
    	    confirm.setContent(content);
    	    content.addComponent(new Label(Messages.getMessage("bot.window.confirm.message", tabName),
    		    ContentMode.HTML));
    	    HorizontalLayout buttons = new HorizontalLayout();
    	    Button ok = new Button(Messages.getMessage("bot.button.yes"), new ClickListener() {
        		@Override
        		public void buttonClick(ClickEvent event) {
        		    removeTab(tabName);
        		    UI.getCurrent().removeWindow(confirm);
        		}
    	    });
    	    ok.setStyleName(Reindeer.BUTTON_DEFAULT);
    	    ok.setClickShortcut(KeyCode.ENTER);
    	    ok.focus();
    	    Button cancel = new Button(Messages.getMessage("bot.button.no"), new ClickListener() {
        		@Override
        		public void buttonClick(ClickEvent event) {
        		    UI.getCurrent().removeWindow(confirm);
        		}
    	    });
    	    cancel.setClickShortcut(KeyCode.ESCAPE);
    	    buttons.addComponents(ok, cancel);
    	    content.addComponent(buttons);
    	    content.setComponentAlignment(buttons, Alignment.BOTTOM_RIGHT);
    	    UI.getCurrent().addWindow(confirm);
    	}
    
    }
    
}
