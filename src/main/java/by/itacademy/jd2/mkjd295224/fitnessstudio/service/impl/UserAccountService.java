package by.itacademy.jd2.mkjd295224.fitnessstudio.service.impl;

import by.itacademy.jd2.mkjd295224.fitnessstudio.repository.IUserAccountRepository;
import by.itacademy.jd2.mkjd295224.fitnessstudio.service.api.IUserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements IUserAccountService {
    private final IUserAccountRepository repository;

    public UserAccountService(IUserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register() {
    }

    @Override
    public void verify() {

    }

    @Override
    public void login() {

    }

    @Override
    public void getInfo() {

    }
}
