package com.cyh.ums.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 验证码验证
 */
public class UserLoginFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpSession session = req.getSession();
        String rom = (String)session.getAttribute("rom");
        String rs = req.getParameter("rs");
        if(!StringUtils.isEmpty(rom) && !StringUtils.isEmpty(rs) && rom.toUpperCase().equals(rs.toUpperCase())){
            return true;
        }
        return super.onAccessDenied(request, response);
    }
}
