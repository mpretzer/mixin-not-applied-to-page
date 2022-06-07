package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

  @Autowired
  private MockMvc mvc;

  @Test
  void listContainsType() throws Exception {
    mvc.perform(get("/list"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].type", is("FooType")));
  }

  @Test
  void pageContainsType() throws Exception {
    mvc.perform(get("/paged"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content[0].type", is("FooType")));
  }
}
