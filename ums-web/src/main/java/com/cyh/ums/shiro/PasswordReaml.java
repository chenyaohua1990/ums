package com.cyh.ums.shiro;

import com.cyh.ums.domain.TUser;
import com.cyh.ums.serviceI.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class PasswordReaml extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        TUser primaryPrincipal = (TUser) principalCollection.getPrimaryPrincipal();

        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        TUser tuser=userService.findByEmail(principal);
        if(ObjectUtils.isEmpty(tuser)){
            return null;
        }else{
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(principal,tuser.getPassword(), ByteSource.Util.bytes(tuser.getSalt()),getName());
            return simpleAuthenticationInfo;
        }
    }


}
