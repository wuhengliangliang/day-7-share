package liangliang.bigdata.security;

import liangliang.bigdata.entity.User;
import liangliang.bigdata.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * 自定义认证实现
 */
public class AuthProvider implements AuthenticationProvider{
    @Autowired
    private IUserService userService;

    private final Md5PasswordEncoder passwordEncoder=new Md5PasswordEncoder();
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=authentication.getName();
        String inputPassword=(String) authentication.getCredentials();
        User user = userService.findUserByName(username);
        if (user==null) {
            throw new AuthenticationCredentialsNotFoundException("authError");
        }
        if (this.passwordEncoder.isPasswordValid(user.getPassword(), inputPassword, user.getId())) {
            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        }else {
            throw new BadCredentialsException("authError");
        }

    }
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}