package com.br.cad.service.impl;

import com.br.cad.domain.AppUser;
import com.br.cad.domain.Role;
import com.br.cad.repository.AppUserRepo;
import com.br.cad.repository.RoleRepo;
import com.br.cad.service.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements AppUserService {

    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveUser(AppUser appUser) {
        log.info("[UserServiceImpl.saveUser] - [ saving new user to the database: {} ]", appUser.toString());
        return appUserRepo.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("[UserServiceImpl.saveRole] - [ saving new role to the database: {} ]", role.toString());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToAppUser(String username, String roleName) {
        log.info("[UserServiceImpl.addRoleToAppUser] - [ adding role {} to user {}]", roleName, username);

        AppUser appUser = appUserRepo.findByUsername(username);
        //Role role = roleRepo.findByRole(roleName);

       // appUser.getRoles().add(role);

    }

    @Override
    public AppUser getAppUser(String username) {
        log.info("[UserServiceImpl.getAppUser] - [ fetching user {}]", username);
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("[UserServiceImpl.getAppUser] - [ fetching all users]");
        return appUserRepo.findAll();
    }
}
