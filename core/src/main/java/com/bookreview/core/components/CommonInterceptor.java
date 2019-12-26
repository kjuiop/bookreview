package com.bookreview.core.components;

import com.bookreview.core.dto.MenuDto;
import com.bookreview.core.exception.RequiredParamNonException;
import com.bookreview.core.model.Account;
import com.bookreview.core.model.types.MenuType;
import com.bookreview.core.service.MenuService;
import com.bookreview.core.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private MenuService menuService;

    @Autowired
    private SecurityService securityService;

    private MenuType menuType;

    /**
     * 메뉴종류를 확인 하기 위한 필수값
     * @param menuType
     */
    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws Exception {
        if (menuType == null) {
            throw new RequiredParamNonException("MenuType is null");
        }
        if (mav != null) {

            Account loginAccount = securityService.getLoginUser();
            if (loginAccount != null) {
                List<MenuDto> menus = menuService.getMenuHierarchyByRoles(menuType, loginAccount.getRoles(), false);
                mav.addObject("menus", menus);
            }

        }
        super.postHandle(request, response, handler, mav);
    }

}
