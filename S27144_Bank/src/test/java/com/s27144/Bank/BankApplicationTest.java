package com.s27144.Bank;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BankApplicationTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserStorage userStorage;

    @AfterEach
    void cleanup()
    {
        userStorage.purgeList();
    }

    @Test
    void shouldNotFindUser()
    {
        //GIWEN
        userStorage.addUser(new User(1,100,"ABC","DEF"));

        //when
        Optional<User> userByID = userService.findUserByID(2);

        //THEN
        assertThat(userByID).isNotPresent();
    }


    @Test
    void shouldFindUser()
    {
        //GIVEN
        userStorage.addUser(new User(1,100,"ABC","DEF"));
        userStorage.addUser(new User(2,1002,"ABSC","DEFG"));

        //WHEN
        Optional<User> userByID = userService.findUserByID(2);

        //THEN
        assertThat(userByID).isPresent();
    }

    @Test
    void shouldFindUser2()
    {
        //GIVEN
        userStorage.addUser(new User(1,100,"ABC","DEF"));

        //WHEN
        Optional<User> userByID = userService.findUserByID(1);

        //THEN
        assertThat(userByID).isPresent();
    }



}
