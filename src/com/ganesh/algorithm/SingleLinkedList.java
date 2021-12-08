/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh.algorithm;

import com.ganesh.algorithm.Exceptions.InvalidElementException;

/*
* This is Service class which will implement Singly linked list different operations*/
public class SingleLinkedList<E>
{
    SingleLinkedListNode<E> head;
    SingleLinkedListNode<E> tail;

   public SingleLinkedList(SingleLinkedList<E> head)
    {
        this.head = new SingleLinkedListNode<>(null  );
        this.tail = new SingleLinkedListNode<>(null  );
    }

    public SingleLinkedList()
    {
    }


    /**
     * This method helps to add Element at the End of the linked list..
     *
     * @author  Ganesh Markande
     * @see
     * @see
     * @since
     */
    public SingleLinkedListNode<E> addElementAtLast(E element)
    {
        if(element == null)
        {
            throw new InvalidElementException();
        }
        SingleLinkedListNode<E> newNode = new SingleLinkedListNode<>( element );
        addNodeAtLast( newNode );
        return newNode;
    }

    /**
     * This method helps to add Node at the End of the linked list..
     *
     * @author  Ganesh Markande
     * @see
     * @see
     * @since
     * @param element
     */
    public void addNodeAtLast(SingleLinkedListNode<E> element)
    {
        if(head == null)
        {
            head = element;
        }
        else
        {
            tail = head;
            while (tail.next != null)
            {
                tail = tail.next;
            }
            tail.next = element;
        }
    }

    public void printList()
    {
        SingleLinkedListNode<E> temp = head;
        while (temp != null)
        {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }
}