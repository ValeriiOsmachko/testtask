package testsrc.facade;

import testsrc.BaseTest;

import java.util.Optional;

import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.entity.User;
import com.ratiose.testtask.exception.InvalidRegisterDataException;
import com.ratiose.testtask.exception.UserAlreadyExistsException;
import com.ratiose.testtask.facade.impl.UserFacadeImpl;
import com.ratiose.testtask.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UserFacadeImplTest extends BaseTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserFacadeImpl testingInstance = new UserFacadeImpl();

    @Test(expected = InvalidRegisterDataException.class)
    public void shouldThrowExceptionWhenNotEnoughRequestData() {
        testingInstance.registerUser(createNotValidRegisterUserDto());
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void shouldThrowExceptionWhenUserAlreadyExists() {
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        when(userService.registerUser(any(RegisterUserDto.class))).thenReturn(optionalUser);
        testingInstance.registerUser(createValidRegisterUserDto());
    }
}