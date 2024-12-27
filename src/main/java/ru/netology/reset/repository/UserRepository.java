package ru.netology.reset.repository;

import org.springframework.stereotype.Repository;
import ru.netology.reset.model.Authorities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    // Мапа для хранения пары "логин" -> "пароль";
    private final Map <String, String> users = new HashMap<>();
    // Мапа для хранения пары "логин" -> "права доступа"
    private final Map<String, List<Authorities>> authorities = new HashMap<>();

    public UserRepository(){
        users.put("admin", "admin123");
        users.put("user", "user123");

        authorities.put("admin", List.of(Authorities.READ,Authorities.WRITE,Authorities.DELETE));
        authorities.put("user", List.of(Authorities.READ,Authorities.WRITE,Authorities.DELETE));
    }
    // репозиторий возвращает разрешения или пустой список, если пользователь не найден
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ((users.containsKey(user)) && users.get(password).equals(password)){
            return authorities.getOrDefault(user, List.of());
        }
        return List.of(); //пустой список, если нет совпадений
    }
}