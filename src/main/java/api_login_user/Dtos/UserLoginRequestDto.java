package api_login_user.Dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
