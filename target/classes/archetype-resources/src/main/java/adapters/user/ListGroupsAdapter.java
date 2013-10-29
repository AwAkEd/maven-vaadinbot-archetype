package ${package}.adapters.user;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import ${package}.security.Group;
import ${package}.menu.Users;
import ${package}.utils.Images;
import ${package}.views.ContentContainer;
import ${package}.views.user.GroupView;

@SuppressWarnings("serial")
public class ListGroupsAdapter implements ClickListener {

    public ContentContainer content;

    public ListGroupsAdapter(ContentContainer content) {
        this.content = content;
    }

    @Override
    public void buttonClick(ClickEvent event) {
    	try {
    	    if (content.findTab(Users.LIST_GROUP.getCaption()) == null) {
    	        content.addManagementTab(new GroupView(Group.class), Users.LIST_GROUP.getCaption(),
    		        Images.getImage("bot.button.show"));
    	    } else {
    	        getViewComponent().refreshTableData();
    	    }
	        content.setSelectedTab(content.findTab(Users.LIST_GROUP.getCaption()));
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }

    private GroupView getViewComponent() {
        return (GroupView) content.findTab(Users.LIST_GROUP.getCaption()).getComponent();
    }

}
