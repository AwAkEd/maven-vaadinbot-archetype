package ${package}.views;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.BrowserFrame;
import com.vaadin.ui.CustomComponent;

import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class WelcomeTab extends CustomComponent {
    public static final String CAPTION = Messages.getMessage("bot.welcome.tab");

    public WelcomeTab() {
    	setSizeFull();
    	BrowserFrame browser = new BrowserFrame("", new ThemeResource("static-content/welcome.html"));
    	browser.setWidth(95, Unit.PERCENTAGE);
    	setCompositionRoot(browser);
    }

}
