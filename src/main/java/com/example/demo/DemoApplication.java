package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoApplication {

  private List<Base> all;

  public DemoApplication() {
    all = Arrays.asList(new Foo(), new Foo());
  }

  @GetMapping("/paged")
  public Page<Base> getPaged(Pageable pageable) {
    return new PageImpl<>(all);
  }

  @GetMapping("/list")
  public List<Base> getAll() {
    return all;
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

}
