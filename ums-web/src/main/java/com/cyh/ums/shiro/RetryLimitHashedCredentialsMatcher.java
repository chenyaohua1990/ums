package com.cyh.ums.shiro;

import com.cyh.ums.util.MD5Utils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken autoken = (UsernamePasswordToken) token;
        SimpleAuthenticationInfo sinfo = (SimpleAuthenticationInfo)info;
        String salt = new String(sinfo.getCredentialsSalt().getBytes());
        String inputCredential = MD5Utils.encode(String.valueOf(autoken.getPassword())+ salt );
        String accountCredentials = String.valueOf(getCredentials(info));
        boolean match = equals(inputCredential,accountCredentials);
        return match;
    }
}
