package com.nt.dao;

import com.nt.bo.UserDetailsBO;

public interface AuthenticateDAO {
     public int validate(UserDetailsBO bo);
}
