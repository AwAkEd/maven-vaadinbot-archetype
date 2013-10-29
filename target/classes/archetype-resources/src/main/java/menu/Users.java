package ${package}.menu;

import ${package}.utils.Messages;

public enum Users {
    LIST_USER (Messages.getMessage("bot.users.menu.user")),
    LIST_GROUP (Messages.getMessage("bot.users.menu.group"));

    String caption;
    
    Users(String caption) {
        this.caption = caption;
    }
    
    public String getCaption() {
        return this.caption;
    }
    
    @Override
    public String toString() {
        return this.caption;
    }

}
