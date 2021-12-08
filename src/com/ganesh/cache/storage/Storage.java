/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.cache.storage;

import com.ganesh.cache.exceptions.NotFoundException;
import com.ganesh.cache.exceptions.StorageFullException;

public interface Storage<Key, Value>
{
    public void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;
}
