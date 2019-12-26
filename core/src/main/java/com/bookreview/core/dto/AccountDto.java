package com.bookreview.core.dto;

import com.bookreview.core.model.Account;
import com.bookreview.core.model.Role;
import com.bookreview.core.model.types.YNType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String username;
    private String email;
    private String businessName;
    private String businessNo;
    private String name;
    private String phone;
    private String birthDate;
    private String zipCode;
    private String address1;
    private String address2;
    private String genderCd;
    private String password;
    private YNType activeYn;
    private YNType dormancyYn;
    private String loginIp;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
    private List<RoleDto> roles = new ArrayList<>();

    public AccountDto(Account u) {
        this(u, false);
    }

    public AccountDto(Account u, boolean isPassword) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.name = u.getName();
        this.activeYn = u.getActiveYn();
        this.dormancyYn = u.getDormancy();
        this.loginIp = u.getLoginIp();

        if (isPassword)
            this.password = u.getPassword();

        this.createdAt = u.getCreatedAt();
        this.lastLoginAt = u.getLastLoginAt();

        if (u.getRoles() != null){
            for (Role r : u.getRoles()){
                RoleDto rDto = new RoleDto(r);
                if(!roles.contains(rDto))
                    roles.add(rDto);
            }
        }
    }
}
