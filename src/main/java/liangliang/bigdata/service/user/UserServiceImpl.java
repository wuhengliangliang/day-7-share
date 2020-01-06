package liangliang.bigdata.service.user;

import liangliang.bigdata.entity.Role;
import liangliang.bigdata.entity.User;
import liangliang.bigdata.repository.RoleRepository;
import liangliang.bigdata.repository.UserRepository;
import liangliang.bigdata.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);

        if (user == null) {
            return null;
        }

        List<Role> roles = roleRepository.findRoleByUserId(user.getId());
        if (roles == null || roles.isEmpty()) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }
}
