package ${package}.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;

public class Images {

    private static final String BUNDLE_NAME = "images"; //$NON-NLS-1$

    private static final String NOT_FOUND_ICON = "icons/16/nok.png"; //$NON-NLS-1$

    private static final ResourceBundle DEFAULT_RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public static ThemeResource getImage(String key) {
    	try {
    	    return new ThemeResource(DEFAULT_RESOURCE_BUNDLE.getString(key));
    	} catch (MissingResourceException e) {
    	    return new ThemeResource(NOT_FOUND_ICON);
    	}
    }

    public static Resource getExternalImage(String key) {
    	try {
    	    return new ExternalResource(DEFAULT_RESOURCE_BUNDLE.getString(key));
    	} catch (MissingResourceException e) {
    	    return new ThemeResource(NOT_FOUND_ICON);
    	}
    }

}
