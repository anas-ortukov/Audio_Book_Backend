package uz.audio_book.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.audio_book.backend.dto.UserDetailsDTO;
import uz.audio_book.backend.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "(For updating and getting user details)")
public class UserController {

    private final UserService userService;

    @Operation(
            summary = "User Info API",
            description = """
                    This API sends info about user who is logged in. Response will be
                    200 (good status) with user details, 404 (not found) when user is not
                    found from db, 403 user is not logged in""")
    @GetMapping("/me")
    public HttpEntity<?> getUserById() {
        return userService.getUserDetails();
    }

@Operation(
        summary = "User Info Update API",
        description = """
                    This API receives new info about user who is logged in. Response will be
                    200 (good status) when user details are updated, 400 (bad request) if sent
                    birth date format is wrong, 404 (not found) when user is not found from db,
                    403 user is not logged in""")
    @PostMapping("/edit")
    public HttpEntity<?> updateUser(@RequestBody UserDetailsDTO userDetailsDTO) {
        return userService.updateUserDetails(userDetailsDTO);
    }

}
