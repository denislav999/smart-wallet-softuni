package app.user.service;

import app.web.dto.RegisterRequest;

public interface UserService {
    public void register(RegisterRequest registerRequest);
}
