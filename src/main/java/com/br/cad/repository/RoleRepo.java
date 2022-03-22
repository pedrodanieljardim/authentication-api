package com.br.cad.repository;

import com.br.cad.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    ///Role findByRole(String name);
}
