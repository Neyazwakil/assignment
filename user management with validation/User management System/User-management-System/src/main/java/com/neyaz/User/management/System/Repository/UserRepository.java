package com.neyaz.User.management.System.Repository;

import com.neyaz.User.management.System.Model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

