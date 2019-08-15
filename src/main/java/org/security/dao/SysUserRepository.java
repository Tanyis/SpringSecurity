package org.security.dao;

import org.security.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tanyi
 * @date 2019/8/13 15:11
 */
//dao接口（这里我采用jpa来实现用户查询的功能）
public interface  SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String username);

}
