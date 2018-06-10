package testsrc.service;

import testsrc.BaseTest;

import java.util.Optional;

import com.ratiose.testtask.entity.User;
import com.ratiose.testtask.repository.UserRepository;
import com.ratiose.testtask.service.impl.UserServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends BaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServiceImpl testingInstance = new UserServiceImpl();

    @Test
    public void shouldReturnNotEmpltyOptional() {
        when(repository.findByEmail(anyString())).thenReturn(createUser());
        Optional<User> optionalUser = testingInstance.registerUser(createValidRegisterUserDto());
        Assert.assertThat(optionalUser.isPresent(), is(false));

    }

    @Test
    public void shouldReturnEmpltyOptional() {
        when(repository.save(any(User.class))).thenReturn(createUser());
        when(repository.findByEmail(anyString())).thenReturn(null);
        Optional<User> optionalUser = testingInstance.registerUser(createValidRegisterUserDto());
        Assert.assertThat(optionalUser.isPresent(), is(true));
    }
}