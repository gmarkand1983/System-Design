/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.cache.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(final String message)
    {
        super(message);
    }
} 