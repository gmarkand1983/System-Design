/*
 * Copyright (C) McAfee LLC, 2021. All Rights Reserved.
 */

package com.ganesh;

import com.ganesh.algorithm.SingleLinkedList;

public class Main
{
    public static void main(String[] args)
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addElementAtLast( 1 );
        singleLinkedList.addElementAtLast( 2 );
        singleLinkedList.addElementAtLast( 3 );
        singleLinkedList.addElementAtLast( 4 );
        singleLinkedList.addElementAtLast( 5 );
        singleLinkedList.addElementAtLast( "test" );
        singleLinkedList.printList();

    }
} 