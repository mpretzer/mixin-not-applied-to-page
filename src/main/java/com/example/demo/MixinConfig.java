package com.example.demo;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = Foo.class, name = "FooType")})
@Configuration
public class MixinConfig {
  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customize() {
    return (builder) -> {
      builder.mixIn(Base.class, MixinConfig.class);
    };
  }
}
