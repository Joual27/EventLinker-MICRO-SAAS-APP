package org.youcode.EventLinkerAPI.applicationEvents.listeners;


import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.applicationEvents.events.ApplicationConfirmedEvent;

@Component
@AllArgsConstructor
public class ApplicationConfirmedListener {
    @EventListener
    public void handleApplicationConfirmedEvent(ApplicationConfirmedEvent event){
        Application application = event.getApplication();
        Double amount = event.getAmount();
    }
}
