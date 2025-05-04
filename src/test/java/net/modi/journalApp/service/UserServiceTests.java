package net.modi.journalApp.service;

import net.modi.journalApp.entity.User;
import net.modi.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @Test
    public void testFindByUserName()
    {
        User user=userRepository.findByUserName("ram");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @Disabled
    @ParameterizedTest
    @CsvSource
   ({
        "1,1,2",
           "2,10,12",
           "3,3,6"
    })
    // @ValueSource
    // @EnumSource
    public void test(int a , int b , int expected)
    {
        assertEquals(expected,a+b);
    }
}
