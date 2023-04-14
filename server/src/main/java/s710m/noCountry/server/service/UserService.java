package s710m.noCountry.server.service;

import s710m.noCountry.server.model.dto.LoginRequestDto;

public interface UserService {
    Object login(LoginRequestDto dto);
    void dataServiceProviderLoad(String fullName, String country, String experienceYears, String kmAround, String profileDescription,Long idCategory, String email, String password);
    void dataClientLoad(String fullName, String country, String email, String password);
}
