# Spring Reactive Data Mongo `Class` serialization example
This repo provides information how to store entities with `Class<T>` fields in MongoDB.
By default Mongo provider does't support such field types.

## To implement `Class<T>` serialization you should:
* Implement bson `Codec`
* Implement bson `CodecProvider`
* Register them to `MongoSettings`
* Create custom spring data `Converter`
* Register it to spring context

_Please refer to `com.example.mongoclasspertist.MongoConfiguration` for implementation details._


## Technology stack:
* Spring boot 2.0.2
* Spring webflux
* Spring data mongo reactive
* Embedded mongo (for tests)
* Lombok

`com.example.mongoclasspertist.ServiceRepositoryTest` provides client calls example.
