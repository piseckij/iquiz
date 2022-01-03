package by.pisetskiy.iquiz.service;

import by.pisetskiy.iquiz.model.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    public void sendAccountCreatedEmail(Employee employee, String password) {
        log.info("Account for user {} with login: {} and password: {}", employee, employee.getEmail(), password);
    }
}
