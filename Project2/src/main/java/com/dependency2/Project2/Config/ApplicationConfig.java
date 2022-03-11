//package com.dependency2.Project2.Config;
//
//import com.dependency2.Project2.dto.BooksInTheLibrary;
//import com.dependency2.Project2.dto.UserBookHistory;
//import com.dependency2.Project2.dto.UserOfLibrary;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//public class ApplicationConfig {
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory ();
//        jedisConFactory.setHostName ("localhost");
//        jedisConFactory.setPort (6379);
//        return jedisConFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String,UserOfLibrary> redisTemplate() {
//        RedisTemplate<String,UserOfLibrary>template = new RedisTemplate<String, UserOfLibrary> ();
//        template.setConnectionFactory (jedisConnectionFactory());
//        template.setKeySerializer (new StringRedisSerializer ());
//        return template;
//    }
//
//    @Bean
//    public RedisTemplate<String,BooksInTheLibrary> redisTemplate1() {
//        RedisTemplate<String,BooksInTheLibrary>template = new RedisTemplate<String, BooksInTheLibrary> ();
//        template.setConnectionFactory (jedisConnectionFactory());
//        template.setKeySerializer (new StringRedisSerializer ());
//        return template;
//    }
//    @Bean
//    public RedisTemplate<String,UserBookHistory> redisTemplate2() {
//        RedisTemplate<String,UserBookHistory>template = new RedisTemplate<String, UserBookHistory> ();
//        template.setConnectionFactory (jedisConnectionFactory());
//        template.setKeySerializer (new StringRedisSerializer ());
//        return template;
//    }
//
//}
