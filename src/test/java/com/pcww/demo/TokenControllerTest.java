package com.pcww.demo;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenControllerTest {
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void loginExample() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "A@gmail.com");
        jsonObject.put("password", "123");
        this.mockMvc.perform(post("/user/login").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(jsonObject.toString()))
                .andDo(print()).andExpect(status().isOk())
                .andDo(document("user-login-example"
                ));
    }

    @Test
    public void logoutExample() throws Exception {
        this.mockMvc.perform(post("/user/logout").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).header("token", "TokenB"))
                .andDo(print()).andExpect(status().isOk())
                .andDo(document("user-logout-example"
                ));
    }

}
