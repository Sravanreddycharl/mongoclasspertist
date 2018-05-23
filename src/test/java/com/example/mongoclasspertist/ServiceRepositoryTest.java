package com.example.mongoclasspertist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceRepositoryTest {

  @Autowired
  private ServiceRepository repository;

  @Test
  public void test() {
    ServiceEntity entity = new ServiceEntity();
    entity.setName("service1");
    entity.setInputClass(String.class);

    repository.save(entity)
        .doOnNext(e -> log.info("Saved entity: {}", e))
    .block();

    repository.findAll()
        .collectList()
        .doOnNext(all -> log.info("All entities from DB: {}", all))
        .block();
  }

}
