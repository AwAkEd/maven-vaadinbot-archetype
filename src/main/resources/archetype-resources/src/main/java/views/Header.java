package ${package}.views;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Reindeer;

import ${package}.utils.Images;
import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class Header extends HorizontalLayout {

    public Header() {
    	setSizeFull();
    	setMargin(false);
    	setSpacing(false);
    	setStyleName(Reindeer.LAYOUT_BLUE);
    
    	Image icon = new Image(null, Images.getImage("bot.logo.icon"));
    	Label caption = new Label(Messages.getMessage("bot.appname"));
    	caption.setStyleName(Reindeer.LABEL_H1);
    
    	addComponents(caption, icon);
    	setComponentAlignment(caption, Alignment.TOP_LEFT);
    	setComponentAlignment(icon, Alignment.BOTTOM_RIGHT);
    }

}
