package org.security.dao;

import org.security.entity.SysUser;

/**
 * @author tanyi
 * @date 2019/8/13 19:07
 */
public interface AuthService  {
    SysUser register(SysUser UserToAdd);
    String login(String username,String password);
    String refresh(String oldToken);

}
