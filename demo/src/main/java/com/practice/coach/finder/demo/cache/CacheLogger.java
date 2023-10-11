package com.practice.coach.finder.demo.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CacheLogger implements CacheEventListener<Object, Object>{

	@Override
    public void onEvent(
      CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        log.info("Caching data: " +  cacheEvent.getNewValue());
    }
}
