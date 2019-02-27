package com.bcx.entity;

import com.bcx.HouseRentApplicationTests;
import com.bcx.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryTest extends HouseRentApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindOne(){
        Optional<User> userOptional = userRepository.findById("1");
        User user = userOptional.get();
        Assert.assertEquals("wali",user.getUserName());
    }
}
