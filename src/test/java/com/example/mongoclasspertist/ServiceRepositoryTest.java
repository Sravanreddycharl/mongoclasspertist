package com.example.mongoclasspertist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceRepositoryTest {

  @Autowired
  private ServiceRepository repository;

  @Test
  public void testSaveAndFetch() {
    ServiceEntity entity = new ServiceEntity();
    entity.setName("service1");
    entity.setInputClass(String.class);

    StepVerifier.create(repository.save(entity))
        .expectSubscription()
        .assertNext(savedEntity -> {
          assertNotNull(savedEntity.getId());
          assertEquals(entity.getName(), savedEntity.getName());
          assertEquals(entity.getInputClass(), savedEntity.getInputClass());
        })
        .verifyComplete();

    StepVerifier.create(repository.findAll())
        .expectSubscription()
        .assertNext(dbEntity -> {
          assertNotNull(dbEntity.getId());
          assertEquals(entity.getName(), dbEntity.getName());
          assertEquals(entity.getInputClass(), dbEntity.getInputClass());
        })
        .verifyComplete();
  }

}
