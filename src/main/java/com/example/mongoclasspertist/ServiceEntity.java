package com.example.mongoclasspertist;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ServiceEntity {

  @Id
  private String id;
  private String name;
  private Class inputClass;
}
