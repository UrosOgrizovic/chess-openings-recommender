package com.cor.backend.model;

import com.cor.backend.service.SpamDetectionService;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("1h")
public class UserEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private boolean isSpam;

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }

    public UserEvent() {
        this.executionTime = new Date();
    }

    public UserEvent(Date executionTime) {
        this.executionTime = executionTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }
}
