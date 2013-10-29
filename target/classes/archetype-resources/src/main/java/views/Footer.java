package ${package}.views;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Reindeer;

import ${package}.utils.Messages;

@SuppressWarnings("serial")
public class Footer extends HorizontalLayout {

    public Footer() {
    	setWidth(100, Unit.PERCENTAGE);
    	setMargin(false);
    	setSpacing(false);
    	setStyleName(Reindeer.LAYOUT_BLUE);
    	Label caption = new Label(Messages.getMessage("bot.footer.default"));
    	caption.setStyleName(Reindeer.LABEL_SMALL);
    	caption.setSizeUndefined();
    	addComponent(caption);
    	setComponentAlignment(caption, Alignment.MIDDLE_CENTER);
    }
}
