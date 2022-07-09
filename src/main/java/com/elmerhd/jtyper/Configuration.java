package com.elmerhd.jtyper;

import java.text.MessageFormat;

/**
 *
 * @author elmerhd
 */
public class Configuration{
    private String uuid;
    private String limit;    
    private String notificationReminder;    
    private String limitMessage;    
    private String blockMessage;    
        
    public Configuration() {    
                
    }        
    
    public Configuration(String uuid, String limit, String notificationReminder, String limitMessage, String blockMessage) {    
        this.uuid = uuid;        
        this.limit = limit;        
        this.notificationReminder = notificationReminder;        
        this.limitMessage = limitMessage;        
        this.blockMessage = blockMessage;        
    }        
    
    public String getLimit() {    
        return limit;        
    }        
    
    public String getBlockMessage() {    
        return blockMessage;        
    }        
    
    public String getLimitMessage() {    
        return limitMessage;        
    }        
    
    public String getNotificationReminder() {    
        return notificationReminder;        
    }        
    
    public void setBlockMessage(String blockMessage) {    
        this.blockMessage = blockMessage;        
    }        
    
    public void setLimit(String limit) {    
        this.limit = limit;        
    }        
    
    public void setLimitMessage(String limitMessage) {    
        this.limitMessage = limitMessage;        
    }        
    
    public void setNotificationReminder(String notificationReminder) {    
        this.notificationReminder = notificationReminder;        
    }        
    
    public void setUuid(String uuid) {    
        this.uuid = uuid;        
    }        
    
    public String getUuid() {    
        return uuid;        
    }        
    
}
