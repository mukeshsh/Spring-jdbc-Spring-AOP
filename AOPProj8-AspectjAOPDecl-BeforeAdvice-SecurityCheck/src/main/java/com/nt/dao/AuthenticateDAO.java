package com.nt.dao;

import com.nt.model.UserDetails;

public interface AuthenticateDAO {
     public int authenticate(UserDetails details);
}
