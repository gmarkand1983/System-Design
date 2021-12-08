/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.cache.policies;

public interface EvictionPolicy<Key>
{
    void keyAccessed(Key key);

    /*
    * Evict the key from eviction policy and return it.
    * */
    Key evictKey();
}
