package com.company;

import java.util.ArrayList;
import java.util.List;

class Node{
    Pegawai pegawai;
    Node next,prev;
}
public class DoublyLinkedList {
    Node head;
    Node tail;

    boolean isEmpty(){
        return (head == null);
    }
    void addFirst(Node input){
        if(isEmpty()){
            head = input;
            tail = input;
        }
        else{
            input.next = head;
            head.prev = input;
            head = input;
        }
    }
    void addLast(Node input){
        if(isEmpty()){
            head = input;
        }
        else{
            tail.next = input;
            input.prev = tail;
        }
        tail = input;
    }
    void insertSorted(Node input){
        if(isEmpty()){
            head = input;
            tail = input;
        }
        else{
            if(input.pegawai.getNip().compareTo(head.pegawai.getNip()) < 0)
                this.addFirst(input);
            else
                if(input.pegawai.getNip().compareTo(tail.pegawai.getNip()) > 0)
                    this.addLast(input);
                else{
                    Node t = head;
                    while (t.pegawai.getNip().compareTo(input.pegawai.getNip())<0) t = t.next;
                    input.next = t;
                    t.prev.next = input;
                    input.prev = t.prev;
                    t.prev = input;
                    }
                }
        }
        List<Pegawai> pegawaiList(){
        List<Pegawai> pegawais = new ArrayList<>();
        Node temp;
        temp = head;
        while (temp!=null){
            pegawais.add(temp.pegawai);
            temp = temp.next;
        }
        return pegawais;
        }
        void printNode(){
        Node temp;
        temp = head;
        while (temp != null){
            System.out.println(temp.pegawai.getInfo());
            temp = temp.next;
        }
            System.out.println();
        }
    }


