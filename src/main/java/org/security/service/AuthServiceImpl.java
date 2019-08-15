package org.security.service;

import org.security.dao.AuthService;
import org.security.dao.SysUserRepository;
import org.security.entity.SysUser;
import org.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author tanyi
 * @date 2019/8/13 21:42
 */
@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private SysUserRepository userRepository;

    @Value("${jwt.tokenHead}")
    private  String tokeHead;

    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtTokenUtil jwtTokenUtil,
            SysUserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }


    @Override
    public SysUser register(SysUser UserToAdd) {
        final String username=UserToAdd.getUsername();
        if(userRepository.findByUsername(username)!=null){
            return null;
        }
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        final String rawpassword=UserToAdd.getPassword();
        UserToAdd.setPassword(encoder.encode(rawpassword));
        UserToAdd.setLastPasswordResetDate(new Date());
        return userRepository.save(UserToAdd);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        final  String token=oldToken.substring(tokeHead.length());
        String username=jwtTokenUtil.getUsernameFromToken(token);
        SysUser user= (SysUser) userDetailsService.loadUserByUsername(username);
        if(jwtTokenUtil.canTokenBeRefreshed(token,user.getLastPasswordResetDate())){
            return  jwtTokenUtil.refreshToken(token);
        }
        return null;
    }
}
