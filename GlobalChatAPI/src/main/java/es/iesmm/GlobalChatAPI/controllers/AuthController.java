package es.iesmm.GlobalChatAPI.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class AuthController {

    @GetMapping("/auth")
    public ResponseEntity<String> auth(){
        return ResponseEntity.ok("Authorized");
    }

}
