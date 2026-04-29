package EEDD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public static class UserRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        if (request.getUsername() == null || request.getUsername().trim().isEmpty() || 
            request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("{\"error\": \"Usuario y contraseña son requeridos.\"}");
        }
        
        Optional<AppUser> existing = userRepository.findByUsername(request.getUsername());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"error\": \"El usuario ya existe.\"}");
        }
        
        AppUser newUser = new AppUser(request.getUsername(), request.getPassword());
        userRepository.save(newUser);
        return ResponseEntity.ok("{\"message\": \"Usuario registrado correctamente.\"}");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest request) {
        if (request.getUsername() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body("{\"error\": \"Usuario y contraseña son requeridos.\"}");
        }
        
        Optional<AppUser> userOpt = userRepository.findByUsername(request.getUsername());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok("{\"message\": \"Login exitoso.\", \"username\": \"" + request.getUsername() + "\"}");
        }
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Credenciales incorrectas.\"}");
    }
}
