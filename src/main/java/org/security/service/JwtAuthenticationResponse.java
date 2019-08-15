package org.security.service;

import java.io.Serializable;

/**
 * @author tanyi
 * @date 2019/8/15 0:38
 */
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = -3795389288920196533L;

    private  String token;

    public JwtAuthenticationResponse() {
        super();
    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
