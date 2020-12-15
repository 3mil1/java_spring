package ee.khk.ikt.demo.service;

import ee.khk.ikt.demo.dto.UsersDto;
import ee.khk.ikt.demo.entity.Users;
import ee.khk.ikt.demo.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
@Service
@AllArgsConstructor
public class DefaultUsersService implements UsersService{
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUsertoUserDto(savedUser);
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException{
        if(isNull(usersDto)){
            throw new ValidationException("Object user is null");
        }
        if(isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deteleUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if(users != null){
            return usersConverter.fromUsertoUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUsertoUserDto)
                .collect(Collectors.toList());
    }
}
