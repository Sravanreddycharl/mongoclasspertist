package com.example.mongoclasspertist;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ServiceRepository extends ReactiveMongoRepository<ServiceEntity, String> {

}
