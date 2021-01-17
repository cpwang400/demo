package com.pcww.demo.rest;

import com.pcww.demo.authorization.services.impl.TokenServiceImpl;
import com.pcww.demo.domain.UserRepository;
import com.pcww.demo.rest.model.UserRead;
import com.pcww.demo.rest.model.UserWrite;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Tag(name = "UserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TokenServiceImpl tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Operation(
            summary = "Create a new user",
            responses = {@ApiResponse(description = "return user id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserWrite.class)))
                    , @ApiResponse(responseCode = "200", description = "User created")
            })
    public ResponseEntity<UserWrite> create(@RequestBody(required = true) UserWrite user) {
        return ResponseEntity.status(HttpStatus.OK).body((userRepository.create(user.toDomain())).toWrite());
    }

    @GetMapping
    @Operation(
            summary = "Find the user by token",
            parameters = {@Parameter(name = "token", description = "the token response from /user/login", in = ParameterIn.HEADER)},
            responses = {@ApiResponse(description = "return user info",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserWrite.class)))
                    , @ApiResponse(responseCode = "200", description = "User exist")
            })
    public ResponseEntity<UserRead> getByToken(HttpServletRequest request) {
        String email = tokenService.get(request.getHeader("token")).getUserEmail();
        userRepository.listAll();
        tokenService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByEmail(email).toRead());
    }
}




