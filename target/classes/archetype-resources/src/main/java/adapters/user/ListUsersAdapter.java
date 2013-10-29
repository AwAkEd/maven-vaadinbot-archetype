package ${package}.adapters.user;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ${package}.security.User;
import ${package}.menu.Users;
import ${package}.utils.Images;
import ${package}.views.ContentContainer;
import ${package}.views.user.UserView;

@SuppressWarnings("serial")
public class ListUsersAdapter implements ClickListener {

    public ContentContainer content;

    public ListUsersAdapter(ContentContainer content) {
        this.content = content;
    }

    @Override
    public void buttonClick(ClickEvent event) {
    	try {
    	    if (content.findTab(Users.LIST_USER.getCaption()) == null) {
    	        content.addManagementTab(new UserView(User.class), Users.LIST_USER.getCaption(),
    		        Images.getImage("bot.button.show"));
    	    } else {
    	        getViewComponent().refreshTableData();
    	    }
	        content.setSelectedTab(content.findTab(Users.LIST_USER.getCaption()));
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }

    private UserView getViewComponent() {
        return (UserView) content.findTab(Users.LIST_USER.getCaption()).getComponent();
    }

}
