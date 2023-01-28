package UserManagement.Controller;


import UserManagement.Model.Roles;
import UserManagement.Model.Users;
import UserManagement.Repository.RoleSQLRepository;
import UserManagement.Repository.UserRolesRepository;
import UserManagement.Repository.UserSQLRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@RestController


public class UserController {

    @Autowired
    UserSQLRepository userSQLRepository;
    @Autowired
    RoleSQLRepository roleSQLRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    Users users = new Users();


    @GetMapping(path = "/users")
    public List<Users> getAllUsers()  {

        return userSQLRepository.findAll();
    }


    @GetMapping(path = "/users/{uuid}")
    public List<Users> getUserByUUID(@PathVariable UUID uuid) {

      return userSQLRepository.findByUuid(uuid);

    }


    @DeleteMapping("/users/delete/{uuid}")
    public boolean deleteUser(@PathVariable UUID uuid) {
        if(!userSQLRepository.findByUuid(uuid).equals(Optional.empty())) {
            userSQLRepository.deleteByUuid(uuid);
            return true;
        }
        return false;
    }

    @PostMapping("/users/add")
    public Users createNewUser(@RequestBody Map<String, String> body) {

        String firstName = body.get("firstName");
        String lastName = body.get("lastName");
        String username = body.get("username");
        String password = body.get("password");
        UUID uuid = users.getUuid();

        Users newUser = new Users(firstName, lastName, username, password, uuid);

        return userSQLRepository.save(newUser);
    }

    @GetMapping(path = "/users/roles")
    public List<Roles> getAllRoles() {

        return roleSQLRepository.findAll();

    }

    @GetMapping(path = "users/userroles")
    public List<Object[]> getUserRoles() {

        return userRolesRepository.findAllRoles();
    }



    private WebClient webClient;

    public UserController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping(path = "/")
    public String index(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                        @AuthenticationPrincipal OAuth2User oauth2User,
                        Model model) {

        model.addAttribute("username", oauth2User.getAttributes().get("login"));
        model.addAttribute("token", authorizedClient.getAccessToken().getTokenValue());
        UUID uuid = users.getUuid();

        Users u  = new Users("null", "null", oauth2User.getAttribute("login"), "null", uuid);
        userSQLRepository.save(u);

        return "Welcome" + model +"!";
    }

}

