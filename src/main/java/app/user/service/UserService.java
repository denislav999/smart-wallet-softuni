package app.user.service;

import app.user.model.User;
import app.web.dto.RegisterRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void register(RegisterRequest registerRequest);
    User getByUsername(String username);

    User getById(UUID id);
    List<User> getAllUsers();
    int totalUsers();
    int totalActiveUsers();
    int totalInactiveUsers();
    int totalAdmins();
    int totalNonAdminUsers();
}
