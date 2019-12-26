package com.bookreview.core.repository;

import com.bookreview.core.model.Menu;
import com.bookreview.core.model.types.MenuType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select distinct m From Menu m join m.roles r " +
            "where m.menuType=:menuType and m.parent is null " +
            "and m.activeYn='Y' " +
            "and m.displayYn='Y' " +
            "and m.deleteYn='N' " +
            "and r.roleName in :roles")
    List<Menu> getTopMenu(@Param("menuType") MenuType menuType, @Param("roles") List<String> roles, Sort sort);
}
