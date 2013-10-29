package ${package}.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Repository;

import com.vaadin.ui.UI;

@Repository
public class Messages {

    static ReloadableResourceBundleMessageSource messageSource;

    @Autowired
    Messages(ReloadableResourceBundleMessageSource messageSource) {
    	Messages.messageSource = messageSource;
    }

    public static String getMessage(String key, Object... params) {
    	try {
    	    return messageSource.getMessage(key, params, UI.getCurrent().getLocale());
    	} catch (NoSuchMessageException e) {
    	    return '!' + key + '!';
    	}
    }

}
