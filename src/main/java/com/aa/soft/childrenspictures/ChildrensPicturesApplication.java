package com.aa.soft.childrenspictures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ChildrensPicturesApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(ChildrensPicturesApplication.class, args);
  }

}
