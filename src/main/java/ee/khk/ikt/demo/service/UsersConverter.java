package ee.khk.ikt.demo.service;

import ee.khk.ikt.demo.dto.UsersDto;
import ee.khk.ikt.demo.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public Users fromUserDtoToUser(UsersDto usersDto){
        Users users = new Users();
        users.setId(usersDto.getId());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        users.setEmail(usersDto.getEmail());
        return users;
    }

    public UsersDto fromUsertoUserDto(Users users){
        return UsersDto.builder()
                .id(users.getId())
                .name(users.getEmail())
                .login(users.getLogin())
                .email(users.getEmail())
                .build();
    }
}
