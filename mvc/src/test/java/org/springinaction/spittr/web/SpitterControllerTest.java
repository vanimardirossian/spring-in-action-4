package org.springinaction.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springinaction.spittr.data.SpitterRepository;
import org.springinaction.spittr.domain.Spitter;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "jbauer@mail.com");
        Spitter saved = new Spitter(24L, unsaved.getUsername(), unsaved.getPassword(), unsaved.getFirstName(), unsaved.getLastName(), unsaved.getEmail());
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/spitter/register")
                        .param("firstName", unsaved.getFirstName())
                        .param("lastName", unsaved.getLastName())
                        .param("username", unsaved.getUsername())
                        .param("password", unsaved.getPassword())
                        .param("email", unsaved.getEmail()))
                .andExpect(redirectedUrl("/spitter/jbauer"));
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }

}
