//package com.bookreview.core.security;
//
//import com.bookreview.core.service.AccountService;
//import com.bookreview.core.util.CommonUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class AuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    final int SESSION_TIMEOUT = 60 * 60;  // 1시간
//
//    @Autowired
//    AccountService accountService;
//
//    public void onAuthenticationSuccess(
//            HttpServletRequest request, HttpServletResponse response, Authentication authentication
//                                                                    )   throws ServletException, IOException {
//        super.onAuthenticationSuccess(request, response, authentication);
//
//        request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT);
//
//        User user = (User) authentication.getPrincipal();
//        String clientIp = CommonUtils.getClientIp(request);
//        accountService.loginSuccess(clientIp, user.getUsername());
//    }
//}
