/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.cache.factories;

import com.ganesh.cache.Cache;
import com.ganesh.cache.policies.LRUEvictionPolicy;
import com.ganesh.cache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value>
{
    public Cache<Key, Value> defaultCache(final int capacity)
    {
        return new Cache<Key, Value>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>(capacity));
    }
} 