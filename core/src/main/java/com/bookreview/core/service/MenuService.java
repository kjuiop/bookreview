package com.bookreview.core.service;

import com.bookreview.core.dto.MenuDto;
import com.bookreview.core.model.Menu;
import com.bookreview.core.model.Role;
import com.bookreview.core.model.types.MenuType;
import com.bookreview.core.model.types.YNType;
import com.bookreview.core.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuService {


    @Autowired
    private MenuRepository menuRepository;


    public List<MenuDto> getMenuHierarchyByRoles(MenuType menuType, Collection<Role> roles, boolean includeNonActive) {
//        List<Menu> topMenus = menuRepository.findDistinctByParentIsNullAndMenuTypeAndDeleteYnAndActiveYnAndRolesIn(
//                menuType, YNType.N, YNType.Y, roles,
//                new Sort(Sort.Direction.ASC, "sortOrder", "id"));


        List<Menu> topMenus = menuRepository.getTopMenu(menuType, roles.stream().map(Role::getRoleName).collect(Collectors.toList()), new Sort(Sort.Direction.ASC, "sortOrder", "id"));
        List<MenuDto> hierarchy = new ArrayList<>();
        for (Menu m : topMenus) {
            if (!includeNonActive && m.getActiveYn() == YNType.N) continue;
            hierarchy.add(new MenuDto(m, roles, true));
        }


        return hierarchy;
    }

}
