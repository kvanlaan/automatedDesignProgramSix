package SPLList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SplList<Node extends SplListKey> implements Iterable<Node> {

    public static boolean df = true;
    public static boolean sort = true;
    public static boolean single = false;
    
    private final list mylist;
    
    public SplList() {
        mylist = new list();
    }

    public static void config(boolean d, boolean srt, boolean sing) {
        df = d;
        sort = srt;
        single = sing;
    }

    public void printConfig() {
        System.out.format("Configuration(df=%b,sort=%b,single=%b).\n\n", df, sort, single);
    }

    public cursor cursor() {
        return new cursor();
    }

    public node insert(Node n) {
        // TO DO
        return mylist.insert(n);
    }

    @Override
    public void forEach(Consumer cnsmr) {
        Iterable.super.forEach(cnsmr); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        // TO DO
        return cursor();
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }

    public class list {

        node head;
        node tail;

        public list() {
            head = null;
            tail = null;
        }

        public node insert(Node n) {
            // TO DO
            node curr_node = new node(n);
            
            if (df) {
                curr_node.delflag = false;
            }
            
            if (head == null) {
                head = curr_node;
                tail = curr_node;
                return curr_node;
            }
            
            if (sort) {
                if (head.me.getKey() >= n.getKey()) { // insert to the head
                    curr_node.right = head;
                    if (!single) {
                        head.left = curr_node;
                    }
                    head = curr_node;
                } else if (tail.me.getKey() < n.getKey()) { // insert to the tail
                    tail.right = curr_node;
                    if (!single) {
                        curr_node.left = tail;
                    }
                    tail = curr_node;
                } else { // insert to the middle
                    node q = head;
                    while (true) {
                        if (q.right.me.getKey() >= n.getKey()) {
                            break;
                        }
                        q = q.right;
                    }
                    if (!single) {
                        // use double-sorted alg
                        curr_node.right = q.right;
                        q.right.left = curr_node;
                        q.right = curr_node;
                        curr_node.left = q;
                    } else {
                        // use single-sorted alg
                        curr_node.right = q.right;
                        q.right = curr_node;
                    }
                }
            } else { // unsorted
                curr_node.right = head;
                if (!single) {
                    head.left = curr_node;
                }
                head = curr_node;
            }
            
            return curr_node;
        }

        public void remove(node prev, node n) {
            // TO DO
            if (df) {
                n.delflag = true;
                return;
            }
            prev.right = n.right;
            if (!single) {
                n.right.left = prev;
            }
        }

    }

    public class node {
        Node me;
        boolean delflag;
        node left;
        node right;

        public node(Node n) {
            // TO DO
            me = n;
            delflag = df;
            left = null;
            right = null;
        }
    }
    
    public class cursor implements Iterator<Node> {
        // TO DO -- add secret sauce
        node pointer;
        node prepointer;
        
        public cursor() {
            // TO DO
            pointer = null;
            prepointer = null;
        }

        @Override
        public void forEachRemaining(Consumer<? super Node> cnsmr) {
            Iterator.super.forEachRemaining(cnsmr); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean hasNext() {
            // TO DO
            if (pointer == null) {
                return mylist.head != null;
            }

            if (df) {
                while (pointer.right != null && pointer.right.delflag) {
                    pointer.right = pointer.right.right;
                }
            }
            
            return pointer.right != null;
        }

        @Override
        public Node next() {
            // TO DO   
            if (pointer == null) {
                pointer = mylist.head;
            } else {
                prepointer = pointer;
                pointer =  pointer.right;
            }
            
            return pointer.me;
        }

        @Override
        public void remove() {
            // TO DO
            mylist.remove(prepointer, pointer);
        }
    }
}
