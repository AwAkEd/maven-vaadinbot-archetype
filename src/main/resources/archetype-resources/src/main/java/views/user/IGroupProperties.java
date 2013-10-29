package ${package}.views.user;

import ${package}.utils.Messages;

public interface IGroupProperties {

    static final String[] I18N_PROPERTIES = new String[] {
        Messages.getMessage( "bot.group.id.human" ),
        Messages.getMessage( "bot.group.name.human" )
    };
    
    static final Object[] PROPERTIES_NAMES = new Object[] {
        "id", "name"
    };

}
