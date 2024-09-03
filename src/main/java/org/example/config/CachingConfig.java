package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@EnableCaching
@Slf4j
@Configuration
public class CachingConfig extends CachingConfigurerSupport implements CachingConfigurer {

    private static final String ERROR_REDIS_MSG = "Cannot establish connection with redis anymore... Exception:";

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory,
                                     @Value("${cache.expiration}") Long duration) {
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration(duration);
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).build();
    }

    private RedisCacheConfiguration redisCacheConfiguration(Long duration) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()))
                .disableKeyPrefix()
                .entryTtl(Duration.ofSeconds(duration));
    }


    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
                log.error(ERROR_REDIS_MSG, e);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
                log.error(ERROR_REDIS_MSG, e);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
                log.error(ERROR_REDIS_MSG, e);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                log.error(ERROR_REDIS_MSG, e);
            }
        };
    }
}
