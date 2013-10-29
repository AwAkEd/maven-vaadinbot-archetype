package ${package}.views.user;

import static ${package}.views.user.IUserProperties.I18N_PROPERTIES;
import static ${package}.views.user.IUserProperties.PROPERTIES_NAMES;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.Reindeer;

import ${package}.security.User;
import ${package}.services.user.IUserService;
import ${package}.utils.Injector;
import ${package}.utils.Messages;
import ${package}.views.ManagementView;

@SuppressWarnings("serial")
public class UserView extends ManagementView<User> implements ClickListener {

    @Autowired
    private transient IUserService<User> userService;

    public UserView(Class<User> clazz) throws Exception {
    	super(clazz);
    	Injector.inject(this);
    	getContainer().addAll(userService.findAll());
    	setTableColumns(PROPERTIES_NAMES, I18N_PROPERTIES);
    	getTable().setCaption(Messages.getMessage("bot.user.table.caption"));
    	getTable().addValueChangeListener(new ValueChangeListener() {
    	    @Override
    	    public void valueChange(ValueChangeEvent event) {
    		if (getTable().getValue() != null) {
    		    User bean = (User) getTable().getValue();
    		    rebind(bean);
    		}
    	    }
    	});
    	visibleFormFields(PROPERTIES_NAMES);
    	requiredFields(PROPERTIES_NAMES);
    	buildActionButtons();
    }

    public UserView(Class<User> clazz, String caption) throws Exception {
    	this(clazz);
    	getTable().setCaption(caption);
    }

    @Override
    public void refreshTableData() {
    	super.refreshTableData();
    	setTableColumns(PROPERTIES_NAMES, I18N_PROPERTIES);
        try {
            getContainer().addAll(userService.findAll());
        } catch (Exception e) {}
    }

    private void buildActionButtons() {
    	Button ok = new Button(Messages.getMessage("bot.button.save"), this);
    	ok.setData(ActionButtons.OK);
    	ok.setStyleName(Reindeer.BUTTON_DEFAULT);
    	ok.setClickShortcut(KeyCode.ENTER);
    	Button cancel = new Button(Messages.getMessage("bot.button.cancel"), this);
    	cancel.setData(ActionButtons.CANCEL);
    	getFooter().addComponents(ok, cancel);
    }

    @Override
    public void buttonClick(ClickEvent event) {
    	switch ((ActionButtons) event.getButton().getData()) {
    	case OK:
    	    if (getFieldGroup().isValid()) {
    	        User user = getFieldGroup().getItemDataSource().getBean();
                try {
        		    userService.save(user);
        		    refreshTableData();
        		    rebind(new User());
                } catch (Exception e) {
                    Notification.show("Error Saving!!!\n", "An error occurred while trying to save the values. \nTry again and if the problem persist contact with Administrator.",
                            Type.ERROR_MESSAGE);
                }
    	    } else {
    		    Notification.show("Invalid Values!!!\n", "There are invalid values, verify that required fields have some value and try again.",
    			    Type.ERROR_MESSAGE);
    	    }
    	    break;
    	case CANCEL:
    	    Notification.show("Changes will be discarded!!!\n",
    		    "Any change made will be reverted unless you had save it before.", Type.WARNING_MESSAGE);
    	    rebind(new User());
    	    break;
    	}
    }

}
