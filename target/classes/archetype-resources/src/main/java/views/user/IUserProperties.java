package ${package}.views.user;

import ${package}.utils.Messages;

public interface IUserProperties {

    static final String[] I18N_PROPERTIES = new String[] {
        Messages.getMessage( "bot.user.id.human" ),
        Messages.getMessage( "bot.user.username.human" ),
        Messages.getMessage( "bot.user.email.human" ),
        Messages.getMessage( "bot.user.blocked.human" )
    };
    
    static final Object[] PROPERTIES_NAMES = new Object[] {
        "id", "username", "email", "blocked"
    };

}
