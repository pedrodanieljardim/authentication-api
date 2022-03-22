package com.br.cad.service;

import com.br.cad.domain.AppUser;
import com.br.cad.domain.Role;

import java.util.List;

public interface AppUserService {

    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String roleName);
    AppUser getAppUser(String username);
    List<AppUser> getUsers();
}
