package ${package}.adapters;

import java.util.Date;

import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;

import ${package}.BotUI;
import ${package}.security.User;
import ${package}.views.MainView;

@SuppressWarnings("serial")
public class LoginAdapter implements ClickListener {
    private AbstractField<String> user;
    private AbstractField<String> pass;

    public LoginAdapter(AbstractField<String> user, AbstractField<String> pass) {
    	this.user = user;
    	this.pass = pass;
    }

    @Override
    public void buttonClick(ClickEvent event) {
    	if (user.getValue() == null || pass.getValue() == null) {
    	    Notification.show("Invalid credentials!! \n", "The data provided is invalid.", Type.ERROR_MESSAGE);
    	    user.setValue("");
    	    pass.setValue("");
    	    user.focus();
    	} else if ("patoto".equals(user.getValue()) || "mikiko".equals(user.getValue())) {
    	    User userLogged = new User(user.getValue(), new Date());
    	    UI.getCurrent().getSession().setAttribute(User.class, userLogged);
    	    ((BotUI) UI.getCurrent()).setLoggedInUser(userLogged);
    	    ((BotUI) UI.getCurrent()).getNavigator().navigateTo(MainView.NAME);
    	} else {
    	    Notification.show("Invalid credentials!! \n", "The data provided is invalid.", Type.ERROR_MESSAGE);
    	    user.setValue("");
    	    pass.setValue("");
    	    user.focus();
    	}
    }

}
