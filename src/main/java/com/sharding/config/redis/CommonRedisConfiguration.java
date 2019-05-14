package com.sharding.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
@Component
public class CommonRedisConfiguration {

  @Autowired
  private CommonRedisProperties commonRedisProperties;

  @Bean(name = "commonRedisConnectionFactory")
  public JedisConnectionFactory commonRedisConnectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    JedisPoolConfig config = new JedisPoolConfig();
    config.setMaxIdle(commonRedisProperties.getMaxIdle());
    config.setMinIdle(commonRedisProperties.getMinIdle());
    config.setMaxTotal(commonRedisProperties.getMaxActive());
    config.setMaxWaitMillis(commonRedisProperties.getMaxWait());
    factory.setPoolConfig(config);
    factory.setHostName(commonRedisProperties.getHost());
    factory.setPort(commonRedisProperties.getPort());
    factory.setDatabase(commonRedisProperties.getDatabase());
    factory.setTimeout(commonRedisProperties.getTimeout()); //设置连接超时时间

    return factory;
  }

  @Bean(name = "commonRedisTemplate")
  public RedisTemplate<String, String> commonRedisTemplate(
      @Qualifier("commonRedisConnectionFactory") RedisConnectionFactory factory) {
    StringRedisTemplate commontemplate = new StringRedisTemplate(factory);
    setSerializer(commontemplate); //设置序列化工具
    return commontemplate;
  }

  private void setSerializer(StringRedisTemplate template) {
    StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    template.setKeySerializer(stringRedisSerializer);
    template.setValueSerializer(stringRedisSerializer);
    template.setHashKeySerializer(stringRedisSerializer);
    template.setHashValueSerializer(stringRedisSerializer);
  }
}
