package ru.netology.reset.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.reset.model.Authorities;
import ru.netology.reset.service.AuthorizationService;

import java.util.List;

//контроллер принимает запросы и передает их в сервис для обработки.
@RestController
public class AuthorizationController {
    private AuthorizationService service;

    // внедряем сервис через конструктор
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}
