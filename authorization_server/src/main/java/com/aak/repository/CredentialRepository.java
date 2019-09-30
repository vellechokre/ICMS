package com.aak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aak.domain.Credential;

/**
 * Project authorization_server
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 27, 2019
 */
public interface CredentialRepository extends JpaRepository<Credential, Long> {

    Credential findByName(String name);
}
