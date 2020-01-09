package com.bookreview.core.dto;

import com.bookreview.core.model.Account;
import com.bookreview.core.model.types.YNType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AccountDto {

    private Long id;
    private String username;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String loginIp;
    private YNType activeYn = YNType.Y;
    private YNType dormancy = YNType.N;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    public AccountDto(Account u) { this(u, false); }

    public AccountDto(Account u, boolean isPassword) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.name = u.getName();
        this.activeYn = u.getActiveYn();
        this.dormancy = u.getDormancyYn();
        this.loginIp = u.getLoginIp();

        if(isPassword)
            this.password = u.getPassword();

        this.createdAt = u.getCreatedAt();
        this.lastLoginAt = u.getLastLoginAt();
    }
}
