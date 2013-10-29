package ${package}.views;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Reindeer;

import ${package}.adapters.LogoutAdapter;
import ${package}.utils.Images;
import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class UserInfo extends HorizontalLayout {

    private Label user = new Label("");
    private Button logout = new Button();


    public UserInfo() {
    	setWidth(100, Unit.PERCENTAGE);
    	setMargin(false);
    	setSpacing(false);
    	setStyleName(Reindeer.LAYOUT_WHITE);
    	logout.addClickListener(new LogoutAdapter());
    	logout.setIcon(Images.getImage("bot.button.logout"));
    	logout.setStyleName(Reindeer.BUTTON_LINK);
    	logout.setDescription(Messages.getMessage("bot.button.logout"));
    	addComponents(user, logout);
    	setComponentAlignment(user, Alignment.MIDDLE_LEFT);
    	setComponentAlignment(logout, Alignment.MIDDLE_RIGHT);
    }
    
    public void updateUsername(String username) {
        user.setCaption(Messages.getMessage("bot.userinfo.caption", username));
    }
    
}
