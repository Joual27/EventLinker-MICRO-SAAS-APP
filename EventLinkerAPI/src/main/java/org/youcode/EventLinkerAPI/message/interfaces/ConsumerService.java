package org.youcode.EventLinkerAPI.message.interfaces;

import org.youcode.EventLinkerAPI.message.Message;

public interface ConsumerService {
    void processMessage(Message message);
}
