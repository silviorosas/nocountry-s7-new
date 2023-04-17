package s710m.noCountry.server.service;

import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.LoginRequestDto;

import java.util.List;

public interface UserService {
    Object login(LoginRequestDto dto);
    void dataServiceProviderLoad(String fullName, String country, String experienceYears, String kmAround, String profileDescription,Long idCategory, String email, String password);
    void dataClientLoad(String fullName, String country, String email, String password);
    void dataAdminLoad(String email, String password);
    List<User> getAllAdminUsers(String authority);
}
