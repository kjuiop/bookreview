package com.bookreview.core.model;

import com.bookreview.core.model.types.YNType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Role implements Serializable {
    @Id
    @Column(length = 20)
    private String roleName;

    @Column
    private String description;

    @Column
    private int sortOrder;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private YNType defaultYn = YNType.N;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ROLE_PRIVILEAGE",
            joinColumns = @JoinColumn(name = "ROLE"),
            inverseJoinColumns = @JoinColumn(name = "PRIVILEAGE")
    )
    private Set<Privilege> privileges = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<Menu> menus = new HashSet<>();
}
