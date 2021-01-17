package com.pcww.demo.rest;

import com.pcww.demo.authorization.model.TokenModel;
import com.pcww.demo.authorization.services.impl.TokenServiceImpl;
import com.pcww.demo.domain.UserRepository;
import com.pcww.demo.rest.model.TokenModelWrite;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@Tag(name = "TokenController")
public class TokenController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenServiceImpl tokenService;

    @PostMapping("/user/login")
    @Operation(
            summary = "Login",
            responses = {@ApiResponse(description = "token",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TokenModel.class)))
                    , @ApiResponse(responseCode = "200", description = "Login success")
            })
    public ResponseEntity<TokenModelWrite> login(@RequestBody(required = true) UserWrite userWrite) {
        return ResponseEntity.status(HttpStatus.OK).body(tokenService.create(userWrite.getEmail()).toWrite());
    }

    @Operation(
            summary = "Logout",
            parameters = {@Parameter(name = "token", description = "the token response from /user/login", in = ParameterIn.HEADER)}
    )
    @PostMapping("/user/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        tokenService.delete(request.getHeader("token"));
        return ResponseEntity.status(HttpStatus.OK).body("logout successfully");
    }
}

