package com.pfa.annotationmanager;

import com.pfa.annotationmanager.controller.AdminController;
import com.pfa.annotationmanager.model.Expert;
import com.pfa.annotationmanager.model.Text;
import com.pfa.annotationmanager.repository.ExpertRepository;
import com.pfa.annotationmanager.repository.TextRepository;
import com.pfa.annotationmanager.user.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class AdminControllerTest {

    @Mock
    private ExpertRepository expertRepository;

    @Mock
    private TextRepository textRepository;

    @InjectMocks
    private AdminController adminController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testAddExpert() throws Exception {
        Expert expert = new Expert("John", "Doe", "john@example.com", "password", Role.EXPERT, 3);
        when(expertRepository.save(any(Expert.class))).thenReturn(expert);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/experts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstname\":\"John\",\"lastname\":\"Doe\",\"email\":\"john@example.com\",\"password\":\"password\"}"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john@example.com"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.password").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("EXPERT"));
    }

    @Test
    public void testRemoveExpert() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/experts/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testAddText() throws Exception {
        Text text = new Text("Sample text");
        when(textRepository.save(any(Text.class))).thenReturn(text);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/texts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\":\"Sample text\"}"))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Sample text"));
    }

    @Test
    public void testStartAnnotations() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/texts/{id}/annotations", 1L))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Annotations started for text with ID: 1"));
    }

    @Test
    public void testEditText() throws Exception {
        Text existingText = new Text("Existing text");
        when(textRepository.findById(anyLong())).thenReturn(Optional.of(existingText));
        when(textRepository.save(any(Text.class))).thenReturn(existingText);

        mockMvc.perform(MockMvcRequestBuilders.put("/admin/texts/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"content\":\"Updated text\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Updated text"));
    }

    @Test
    public void testDeleteText() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/texts/{id}", 1L))
                .andExpect(status().isNoContent());
    }
}
