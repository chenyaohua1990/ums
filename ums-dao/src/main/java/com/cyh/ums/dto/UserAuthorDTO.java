package com.cyh.ums.dto;

import com.cyh.ums.domain.Menu;
import com.cyh.ums.domain.TRole;
import com.cyh.ums.domain.TUser;

import java.util.Set;


public class UserAuthorDTO extends TUser{

    private Set<TRole> roles;

    private Set<Menu> menus;

    public Set<TRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<TRole> roles) {
        this.roles = roles;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
