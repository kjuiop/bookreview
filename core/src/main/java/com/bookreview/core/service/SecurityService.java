package com.bookreview.core.service;

import com.bookreview.core.model.Account;
import com.bookreview.core.model.types.YNType;
import com.bookreview.core.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    AccountRepository accountRepository;

    public Account getLoginUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        Optional<Account> findUser = accountRepository.findByUsernameIgnoreCaseAndActiveYn(username, YNType.Y);
        if (findUser.isEmpty()) {
            //throw new UserNotFoundException(username, UserNotFoundException.USER_NOT_FOUND);
            return null;
        }
        return findUser.get();

    }
}
