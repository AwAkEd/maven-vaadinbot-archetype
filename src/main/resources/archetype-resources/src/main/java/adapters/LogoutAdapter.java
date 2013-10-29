package ${package}.adapters;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;

import ${package}.BotUI;
import ${package}.security.User;
import ${package}.views.LoginView;

@SuppressWarnings("serial")
public class LogoutAdapter implements ClickListener {

    @Override
    public void buttonClick(ClickEvent event) {
    	UI.getCurrent().getSession().setAttribute(User.class, null);
    	((BotUI) UI.getCurrent()).setLoggedInUser((User)null);
    	((BotUI) UI.getCurrent()).getNavigator().navigateTo(LoginView.NAME);
    }

}
