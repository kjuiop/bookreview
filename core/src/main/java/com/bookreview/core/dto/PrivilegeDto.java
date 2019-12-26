package com.bookreview.core.dto;

import com.bookreview.core.model.Privilege;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrivilegeDto {
    private String privilege;
    private String description;

    public PrivilegeDto(Privilege p) {
        this.privilege = p.getPrivilege();
        this.description = p.getDescription();
    }
}
