package ${package}.menu;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

import ${package}.adapters.user.ListGroupsAdapter;
import ${package}.adapters.user.ListUsersAdapter;
import ${package}.utils.Images;
import ${package}.utils.Messages;
import ${package}.views.ContentContainer;

@SuppressWarnings("serial")
public class MenuUser extends VerticalLayout {
    public static final String USER_INFO = Messages.getMessage("bot.user.menu");

    private Button showUsers = new Button(Users.LIST_USER.getCaption());

    private Button showGroups = new Button(Users.LIST_GROUP.getCaption());

    public MenuUser(ContentContainer content) {
    	showUsers.addClickListener(new ListUsersAdapter(content));
    	showUsers.setIcon(Images.getImage("bot.button.show"));
    	showUsers.setStyleName(Reindeer.BUTTON_LINK);
    	showGroups.addClickListener(new ListGroupsAdapter(content));
    	showGroups.setIcon(Images.getImage("bot.button.show"));
    	showGroups.setStyleName(Reindeer.BUTTON_LINK);
    	addComponents(showUsers, showGroups);
    }

}
