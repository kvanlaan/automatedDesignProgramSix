package SPLList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SplList<Node extends SplListKey> implements Iterable<Node> {

    public static boolean df = true;
    public static boolean sort = false;
    public static boolean single = false;

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
        return null;
    }

    @Override
    public void forEach(Consumer cnsmr) {
        Iterable.super.forEach(cnsmr); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        // TO DO
        return null;
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
            return null;
        }

        public void remove(node prev, node n) {
            // TO DO
        }

    }

    public class node {
        Node me;
        boolean delflag;
        node left;
        node right;

        public node(Node n) {
            // TO DO
        }
    }

    public class cursor implements Iterator<Node> {
        // TO DO -- add secret sauce
        
        public cursor() {
            // TO DO
        }

        @Override
        public void forEachRemaining(Consumer<? super Node> cnsmr) {
            Iterator.super.forEachRemaining(cnsmr); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean hasNext() {
            // TO DO
            return true;
        }

        @Override
        public Node next() {
            // TO DO
            return null;
        }

        @Override
        public void remove() {
            // TO DO
        }
    }
}
