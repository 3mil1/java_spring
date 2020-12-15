package ee.khk.ikt.demo.controller;

import ee.khk.ikt.demo.dto.UsersDto;
import ee.khk.ikt.demo.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping(value="/users")
@AllArgsConstructor
@Log
public class UsersController {
    private final UsersService usersService;

    //@PostMapping(value="/save")
    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException{
        log.info("Handling save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    //@GetMapping("/findAll")
    @RequestMapping(value="/findAll", method = RequestMethod.GET)
    public List<UsersDto> findAllUsers(){
        log.info("Handling find all users");
        return usersService.findAll();
    }

    //@GetMapping("/findByLogin")
    @RequestMapping(value="/findByLogin", method = RequestMethod.GET)
    public UsersDto findByLogin(@RequestParam String login){
        log.info("Handling find by login: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Handling delete user" + id);
        usersService.deteleUser(id);
        return ResponseEntity.ok().build();
    }
}
