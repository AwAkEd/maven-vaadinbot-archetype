package ${package};

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import ${package}.security.User;
import ${package}.views.LoginView;
import ${package}.views.MainView;

@Theme("bot")
@PreserveOnRefresh
@SuppressWarnings("serial")
public class BotUI extends UI {

    private Navigator navigator;
    private User loggedInUser;

    @Override
    protected void init(VaadinRequest request) {
    	navigator = new Navigator(this, this);
    	navigator.addView(MainView.NAME, MainView.class);
    	navigator.addView(LoginView.NAME, LoginView.class);
    	navigator.addViewChangeListener(new ViewChangeListener() {
    
    	    @Override
    	    public boolean beforeViewChange(ViewChangeEvent event) {
        		User sessionUser = getSession().getAttribute(User.class);
        		boolean isLoggedIn = sessionUser != null;
                boolean isLoginView = event.getNewView() instanceof LoginView;
                if (!isLoggedIn && !isLoginView) {
        		    getNavigator().navigateTo(LoginView.NAME);
        		    return false;
        		} else if (isLoggedIn && isLoginView) {
        		    return false;
                } 
        		return true;
    	    }
    
    	    @Override
    	    public void afterViewChange(ViewChangeEvent event) {
    
    	    }
    	});
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public Navigator getNavigator() {
        return navigator;
    }
}
