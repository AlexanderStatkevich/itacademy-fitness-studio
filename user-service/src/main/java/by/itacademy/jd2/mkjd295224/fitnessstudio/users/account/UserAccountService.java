package by.itacademy.jd2.mkjd295224.fitnessstudio.users.account;

import by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing.UserAccountClient;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing.UserRegisteredEvent;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.account.mailing.dto.EmailVerificationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.User;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserRole;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.domain.UserStatus;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserLoginDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.UserRegistrationDto;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.dto.mapper.UserMapper;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.security.UserHolder;
import by.itacademy.jd2.mkjd295224.fitnessstudio.users.security.jwt.JwtTokenProcessor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserAccountService implements IUserAccountService, UserDetailsService {
    private final IUserAccountRepository repository;
    private final UserAccountClient userAccountClient;
    private final JwtTokenProcessor jwtTokenProcessor;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserHolder userHolder;
    private final ApplicationEventPublisher applicationEventPublisher;


    public UserAccountService(IUserAccountRepository repository,
                              UserAccountClient userAccountClient,
                              JwtTokenProcessor jwtTokenProcessor,
                              PasswordEncoder passwordEncoder,
                              UserMapper userMapper,
                              UserHolder userHolder,
                              ApplicationEventPublisher applicationEventPublisher) {
        this.repository = repository;
        this.userAccountClient = userAccountClient;
        this.jwtTokenProcessor = jwtTokenProcessor;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userHolder = userHolder;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void register(UserRegistrationDto userRegistrationDto) {
        User user = userMapper.toEntity(userRegistrationDto);
        user.setUuid(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.password()));
        user.setStatus(UserStatus.WAITING_ACTIVATION);
        user.setRole(UserRole.USER);
        repository.save(user);
        applicationEventPublisher.publishEvent(new UserRegisteredEvent(user));
    }

    @Transactional
    @Override
    public boolean verify(EmailVerificationDto emailVerificationDto) {
        String email = emailVerificationDto.mail();
        String code = emailVerificationDto.code();
        Boolean verify = userAccountClient.verify(email, code);
        if (verify) {
            repository.activateUserByEmail(email);
        }
        return verify;
    }

    @Override
    public String login(UserLoginDto userLoginDto) {
        String email = userLoginDto.email();
        String enteredPassword = userLoginDto.password();
        User user = repository.findUserByEmail(email);
        String actualPassword = user.getPassword();
        if (!passwordEncoder.matches(enteredPassword, actualPassword)) {
            throw new BadCredentialsException("invalid password");
        }
        return jwtTokenProcessor.generateAccessToken(user);
    }

    @Override
    public UserDto getInfo() {
        UserDetails userDetails = userHolder.getUser();
        String username = userDetails.getUsername();
        User user = repository.findUserByEmail(username);
        return userMapper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByEmail(username);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.singleton(user.getRole()));
    }
}
