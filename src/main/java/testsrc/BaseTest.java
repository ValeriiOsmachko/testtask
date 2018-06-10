package testsrc;


import com.ratiose.testtask.dto.RegisterUserDto;
import com.ratiose.testtask.entity.User;

public class BaseTest {

    private static final String USER_NAME = "PetroPetrovic";
    private static final String EMAIL = "petro@gmail.com";
    private static final String USER_PASSWORD = "1234petro";


    protected RegisterUserDto createValidRegisterUserDto() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setEmail(EMAIL);
        registerUserDto.setPassword(USER_PASSWORD);
        registerUserDto.setUserName(USER_NAME);
        return registerUserDto;
    }

    protected RegisterUserDto createNotValidRegisterUserDto() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setEmail(EMAIL);
        registerUserDto.setPassword(USER_PASSWORD);
        return registerUserDto;
    }

    protected User createUser() {
        User user = new User();
        user.setEmail(EMAIL);
        user.setPassword(USER_PASSWORD);
        return user;
    }
}
