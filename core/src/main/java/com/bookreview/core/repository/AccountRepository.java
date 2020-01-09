//package com.bookreview.core.repository;
//
//import com.bookreview.core.model.Account;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//
//@Repository
//public interface AccountRepository extends JpaRepository<Account, Long> {
//
//    @Modifying
//    @Query("UPDATE Account u set u.passwordFailCnt = u.passwordFailCnt + 1, u.passwordFailTime=current_timestamp WHERE upper(u.username) = upper(:username)")
//    void addPasswordFailCntCount(@Param("username") String username);
//
//    @Modifying
//    @Query("UPDATE Account u set u.passwordFailCnt=0, u.passwordFailTime=null WHERE upper(u.username) = upper(:username)")
//    void resetPasswordFailure(@Param("username") String username);
//
//
//    @Modifying
//    @Query("UPDATE Account u set u.lastLoginAt = :loginAt, u.passwordFailCnt=0, u.loginIp=:clientIp WHERE upper(u.username) = upper(:username)")
//    void setLoginSuccess(@Param("loginAt") LocalDateTime loginAt, @Param("clientIp") String clientIp, @Param("username") String username);
//}
