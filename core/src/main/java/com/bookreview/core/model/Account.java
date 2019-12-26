package com.bookreview.core.model;

import com.bookreview.core.dto.AccountDto;
import com.bookreview.core.model.types.YNType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column(length = 50)
    private String name;

    @Column
    private LocalDateTime passwordModifyAt = LocalDateTime.now();

    @Column
    private int passwordFailCnt = 0;

    @Column
    private LocalDateTime lastLoginAt;

    @Column
    private String loginIp;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private YNType activeYn = YNType.Y;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private YNType dormancy = YNType.N;

    @Column
    private LocalDateTime termApplyAt = LocalDateTime.now();

    @Column
    private LocalDateTime privacyApplyAt = LocalDateTime.now();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ACCOUNT_ROLE",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE")
    )
    private Set<Role> roles = new HashSet<>();

    @NotNull
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist(){
        LocalDateTime dateTime = LocalDateTime.now();
        this.createdAt = dateTime;
        this.updatedAt = dateTime;
    }

    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Account(AccountDto dto) {
        if(dto.getId() != null)
            this.setId(dto.getId());
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.username = dto.getUsername();
        this.password = dto.getPassword();
        this.activeYn = dto.getActiveYn();
    }

}
