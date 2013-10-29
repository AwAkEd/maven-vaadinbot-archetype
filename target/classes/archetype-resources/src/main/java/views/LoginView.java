package ${package}.views;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import ${package}.adapters.LoginAdapter;
import ${package}.utils.Images;
import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements View {

    public static final String NAME = "login";

    public LoginView() {
    	setWidth(100, Unit.PERCENTAGE);
    	setHeight(100, Unit.PERCENTAGE);
    	setMargin(true);
    	setSpacing(true);
    	Panel loginPanel = new Panel(Messages.getMessage("bot.login.header"));
    	loginPanel.setSizeUndefined();
    	loginPanel.setIcon(Images.getImage("bot.logo.icon"));
    
    	final TextField user = new TextField(Messages.getMessage("bot.login.username"));
    	user.focus();
    	final PasswordField password = new PasswordField(Messages.getMessage("bot.login.pass"));
    
    	final Button login = new Button(Messages.getMessage("bot.button.login"), new LoginAdapter(user, password));
    	login.setIcon(Images.getImage("bot.button.ok"));
    	login.setStyleName(Reindeer.BUTTON_DEFAULT);
    	login.setClickShortcut(KeyCode.ENTER);
    	FormLayout layout = new FormLayout(user, password, login);
    	layout.setMargin(true);
    	layout.setSpacing(true);
    	layout.setSizeUndefined();
    	loginPanel.setContent(layout);
    	addComponent(loginPanel);
    	setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }
}
