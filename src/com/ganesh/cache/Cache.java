/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.cache;

import com.ganesh.cache.exceptions.NotFoundException;
import com.ganesh.cache.exceptions.StorageFullException;
import com.ganesh.cache.policies.EvictionPolicy;
import com.ganesh.cache.policies.LRUEvictionPolicy;
import com.ganesh.cache.storage.HashMapBasedStorage;
import com.ganesh.cache.storage.Storage;

public class Cache<Key, Value>
{
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(LRUEvictionPolicy<Key> evictionPolicy, HashMapBasedStorage<Key, Value> storage)
    {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value)
    {
        try
        {
            this.storage.add( key,value );
            this.evictionPolicy.keyAccessed( key );
        }
        catch (StorageFullException exception)
        {
            System.out.println("Got Storage full. Will try to evict some key");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get( key );
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}