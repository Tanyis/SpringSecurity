package org.security.service;

import java.io.Serializable;

/**
 * @author tanyi
 * @date 2019/8/15 0:36
 */
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 337861010906267506L;

    private  String username;
    private  String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
