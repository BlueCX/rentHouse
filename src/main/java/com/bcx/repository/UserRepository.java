package com.bcx.repository;

import com.bcx.entity.User;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface UserRepository extends CrudRepository<User,String> {
}
