package com.bookreview.core.dto;

import com.bookreview.core.model.Role;
import com.bookreview.core.model.types.YNType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private String roleName;
    private String description;
    private YNType defaultYn;
    private List<PrivilegeDto> privileges;

    public RoleDto(Role r) {

    }
}
