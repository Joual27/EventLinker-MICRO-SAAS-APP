package org.youcode.EventLinkerAPI.applicationEvents.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.youcode.EventLinkerAPI.application.Application;

@Getter
public class ApplicationConfirmedEvent extends ApplicationEvent {
    private final Application application;
    private final Double amount ;


    public ApplicationConfirmedEvent(Object source , Application application, Double amount){
        super(source);
        this.application = application;
        this.amount = amount;
    }

}
