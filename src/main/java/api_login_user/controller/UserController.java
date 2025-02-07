package api_login_user.controller;

import api_login_user.Dtos.UserLoginRequestDto;
import api_login_user.Dtos.UserRegisterRequestDto;
import api_login_user.Dtos.UserUpdatePasswordDto;
import api_login_user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api_login_user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequestDto request) {
        try {
            UserModel user = new UserModel();
            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            return ResponseEntity.ok(userService.register(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Email already in use");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto request) {
        try {
            return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UserUpdatePasswordDto request) {
        try {
            UserModel updatedUser = userService.updatePassword(request.getEmail(), request.getNewPassword());
            return ResponseEntity.ok("Password updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        try {
            userService.deleteUserByEmail(email);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}


