package com.example.guavedemocache.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class SharedService {

    LoadingCache<UUID, String> loadingCache;


    public SharedService() {
        this.loadingCache = CacheBuilder.newBuilder().
                expireAfterAccess(3, TimeUnit.MINUTES).
                build(new CacheLoader<UUID, String>() {
                    @Override
                    public String load(UUID uuid) throws Exception {
                        return null;
                    }
                });
    }


    public UUID generateCache(){

        UUID uuid = UUID.randomUUID();
        loadingCache.put(uuid,"Fırat");
        return uuid;
    }

    public String getCache(UUID uuid){

        String name = loadingCache.getIfPresent(uuid);

        return name;
    }


}
