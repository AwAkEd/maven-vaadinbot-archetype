package ${package}.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ${package}.BotUI;
import ${package}.menu.MenuUser;
import ${package}.security.User;
import ${package}.utils.Images;
import ${package}.utils.Injector;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View {

    public static final String NAME = "";

    private Header header = new Header();

    private UserInfo userInfo = new UserInfo();

    private MainContent mainContent = new MainContent();

    private Menu menu = new Menu();

    private ContentContainer content = new ContentContainer();

    private Footer footer = new Footer();

    public MainView() {
    	Injector.inject(this);
    	setSizeFull();
    	setMargin(false);
    	setSpacing(false);
    
    	menu.addTab(new MenuUser(content), MenuUser.USER_INFO, Images.getImage("bot.tab.icon"));
    	mainContent.addComponents(menu, content);
    	mainContent.setExpandRatio(menu, 1);
    	mainContent.setExpandRatio(content, 4);
    	addComponents(header, userInfo, mainContent, footer);
    	setExpandRatio(header, 1);
    	setExpandRatio(userInfo, 1);
    	setExpandRatio(mainContent, 10);
    	setComponentAlignment(mainContent, Alignment.TOP_LEFT);
    	setExpandRatio(footer, 1);
    }

    public ContentContainer getContent() {
        return content;
    }

    @Override
    public void enter(ViewChangeEvent event) {
    	User sessionUser = getSession().getAttribute(User.class);
    	if (sessionUser == null ) {
    	    ((BotUI)UI.getCurrent()).getNavigator().navigateTo(LoginView.NAME);
    	} else if (userInfo != null) {
    	    userInfo.updateUsername(sessionUser.getUsername());
    	}
    }
}
