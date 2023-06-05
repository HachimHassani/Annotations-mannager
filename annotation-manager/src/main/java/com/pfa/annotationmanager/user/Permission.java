package com.pfa.annotationmanager.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    EXPERT_READ("management:read"),
    EXPERT_UPDATE("management:update"),
    EXPERT_CREATE("management:create"),
    EXPERT_DELETE("management:delete")

    ;

    @Getter
    private final String permission;
}
