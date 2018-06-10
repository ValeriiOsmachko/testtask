package testsrc.controller;

import testsrc.BaseTest;

import com.ratiose.testtask.controller.UserController;
import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.facade.UserFacade;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest extends BaseTest{

    @Mock
    private UserFacade userFacade;

    @InjectMocks
    private UserController testingInstance = new UserController();

    @Spy
    private UserController spyTestingInstance = new UserController();

    @Test
    public void shouldCallUserFacadeOnce() {
        RegisterUserDto registerUserDto = createValidRegisterUserDto();
        testingInstance.registerUser(registerUserDto);
        verify(userFacade).registerUser(registerUserDto);
    }
}