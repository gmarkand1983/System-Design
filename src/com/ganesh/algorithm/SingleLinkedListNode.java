/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.algorithm;

/* Single linked list node Structure
* Object which is inserted in the (@Link SingleLinkedList). A single node is expected to be created from this.
*
* @Param <E> Type of element to be inserted into linked list
*
* */
public class SingleLinkedListNode<E>
{
    SingleLinkedListNode<E> next;
    E element;

    public SingleLinkedListNode(E element)
    {
        this.element = element;
        this.next = null;
    }
}