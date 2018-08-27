package com.cyh.ums.serviceI;

import com.cyh.ums.domain.TUser;

public interface UserService {

    TUser login(TUser user);

    String translate(String query);
}
