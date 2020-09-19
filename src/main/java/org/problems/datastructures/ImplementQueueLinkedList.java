package org.problems.datastructures;

/**
 * Implement Queue using Linked List
 */
public class ImplementQueueLinkedList {
    
    static class Node {
        public Node next;
        public Node prev;
        public int val;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    static class Queue {
        
        private Node head;
        private Node first;
        private Node last;
        private int size = 0;
        
        public Queue() {
            head = new Node(0);
            last = head;
        }
        
        public void addFirst(Integer data) {
            first = new Node(data);
            first.prev = head;
            if (head.next != null) {
                first.next = head.next; 
                head.next.prev = first;
            }else {
                last = first; 
            }
            head.next = first;
            size ++;
        }
        
        public void addLast(Integer data) {
            Node lastest = new Node(data);
            lastest.prev = last;
            last.next = lastest;
            last = lastest;
            size ++;
        }
        
        public int removeFirst() {
            Node first = head.next;
            head.next = first.next;
            size --;
            return first.val;
        }
 
        public int removeLast() {
            Node l = last;
            last = last.prev;
            size --;
            return l.val;
        }
        
        public int size() {
            return size;
        }
 
    }

	public static void main(String[] arg) {
	    
	    Queue q = new Queue();
	    q.addFirst(1);
        q.addFirst(2);

		System.out.println(q.removeLast());
        System.out.println(q.removeLast());
        
        Queue q1 = new Queue();
        q1.addFirst(1);
        q1.addFirst(2);
        q1.addLast(3);//2 1 3

        System.out.println(q1.removeLast());//3
        System.out.println(q1.removeFirst());//2
        System.out.println(q1.removeFirst());//1


	}

}
