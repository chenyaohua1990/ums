package com.cyh.ums.serviceI;

import com.cyh.ums.domain.TUser;

public interface UserService {

    String translate(String query);

    TUser findByEmail(String principal);
}
