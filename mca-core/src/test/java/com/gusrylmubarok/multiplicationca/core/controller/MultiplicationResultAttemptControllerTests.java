package com.gusrylmubarok.multiplicationca.core.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gusrylmubarok.multiplicationca.core.domain.Multiplication;
import com.gusrylmubarok.multiplicationca.core.domain.MultiplicationResultAttempt;
import com.gusrylmubarok.multiplicationca.core.domain.User;
import com.gusrylmubarok.multiplicationca.core.service.MultiplicationService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MultiplicationResultAttemptController.class)
public class MultiplicationResultAttemptControllerTests {
    @MockBean
    private MultiplicationService multiplicationService;
    @Autowired
    private MockMvc mvc;
    // These objects will be magically initialized by the initFields method below.
    private JacksonTester<MultiplicationResultAttempt> jsonResultAttempt;
    private JacksonTester<List<MultiplicationResultAttempt>> jsonResultAttemptList;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void postResultReturnCorrect() throws Exception {
        genericParameterizedTest(true);
    }

    @Test
    public void postResultReturnNotCorrect() throws Exception {
        genericParameterizedTest(false);
    }

    void genericParameterizedTest(final boolean correct) throws Exception {
        // given (remember we're not testing here the service itself)
        given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class))).willReturn(correct);
        User user = new User("abdul_budi");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500, correct);

        // when
        MockHttpServletResponse response = mvc
                .perform(post("/results").contentType(MediaType.APPLICATION_JSON)
                                .content(jsonResultAttempt.write(attempt).getJson()))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonResultAttempt
                .write(new MultiplicationResultAttempt(attempt.getUser(),
                        attempt.getMultiplication(),
                        attempt.getResultAttempt(),
                        correct)).getJson());
    }

    @Test
    public void getUserStats() throws Exception {
        // given
        User user = new User("abdul_budi");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500, true);
        List<MultiplicationResultAttempt> recentAttempts = Lists.newArrayList(attempt, attempt);
        given(multiplicationService.getStatsForUser("abdul_budi"))
                .willReturn(recentAttempts);

        // when
        MockHttpServletResponse response = mvc
                .perform(get("/results").param("alias", "abdul_budi"))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonResultAttemptList
                .write(recentAttempts).getJson());
    }

}
