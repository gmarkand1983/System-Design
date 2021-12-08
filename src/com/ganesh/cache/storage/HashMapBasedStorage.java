/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.cache.storage;

import com.ganesh.cache.exceptions.NotFoundException;
import com.ganesh.cache.exceptions.StorageFullException;

import java.util.HashMap;

public class HashMapBasedStorage<Key, Value> implements Storage<Key,Value>
{
    HashMap<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity)
    {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException
    {
        if(isStorageFull())
        {
            throw new StorageFullException();
        }
        storage.put( key,value );
    }

    @Override
    public void remove(Key key) throws NotFoundException
    {
        if(!storage.containsKey( key ))
        {
            throw new NotFoundException(key + " Doesnt exist in cache");
        }
        storage.remove( key );
    }

    @Override
    public void get(Key key) throws NotFoundException
    {
        if(!storage.containsKey( key ))
        {
            throw new NotFoundException(key + " Doesnt exist in cache");
        }
        storage.get( key );
    }

    private boolean isStorageFull()
    {
        return storage.size() == capacity;
    }
}