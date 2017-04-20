package io.cloudlib.spring.cloud.configuration;
/*package io.cloudlib.spring.cloud.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@ConfigurationProperties
@Configuration
public class CacheConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CacheConfig.class);

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;
    
    @Value("${application.cache.max-active-connections}")
    private int maxActiveConnections;
    @Value("${application.cache.max-wait-millis}")
	private long maxWaitMillis;
    @Value("${application.cache.default-expiration}")
	private long defaultExpiration;

    @Bean
    public CacheManager cacheManager() {
        RedisCacheManager manager = new RedisCacheManager(redisTemplate(redisConnectionFactory()));
        manager.setDefaultExpiration(this.defaultExpiration);
        return manager;
    }

    @Bean(name="redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(rcf);
        return redisTemplate;
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(this.maxActiveConnections);
        poolConfig.setMaxWaitMillis(this.maxWaitMillis);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);

        JedisConnectionFactory cf = new JedisConnectionFactory(poolConfig);
        cf.setUsePool(true);

        LOG.info("REDISCACHE_HOSTNAME={}", redisHost);
        cf.setHostName(redisHost);
        LOG.info("REDISCACHE_PORT= {}", redisPort);
        try {
            cf.setPort(redisPort);
        } catch (NumberFormatException e) {
            // if the port is not in the ENV, use the default
            cf.setPort(6379);
        }

        cf.afterPropertiesSet();
        RedisTemplate<Object,Object> tmp = new RedisTemplate<>();
        tmp.setConnectionFactory(cf);

        //make sure redis connection is working
        try {
            String msg = tmp.getConnectionFactory().getConnection().ping();
            LOG.info("redis ping response = {}", msg);
            //clear the cache before use
            tmp.getConnectionFactory().getConnection().flushAll();
        } catch (Exception e) {
            LOG.error("Error pinging redis {}", e);
        }
        return cf;
    }
}
*/