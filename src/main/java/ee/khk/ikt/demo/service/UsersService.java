package ee.khk.ikt.demo.service;

import ee.khk.ikt.demo.dto.UsersDto;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface UsersService {
    UsersDto saveUser(UsersDto usersDto) throws ValidationException;
    void deteleUser(Integer userId);
    UsersDto findByLogin(String login);
    List<UsersDto> findAll();
}
