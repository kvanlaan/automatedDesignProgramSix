package listspl;

import SPLList.*;

public class Main {

    static Person[] array = {
        new Person("anna", 100, 12, "cleveland"),
        new Person("don", 87, 35, "austin"),
        new Person("alex", 26, 44, "austin"),
        new Person("han", 24, 56, "houston"),
        new Person("steve", 67, 50, "cleveland"),
        new Person("jolan", 90, 12, "cleveland")};
            
    public static void main(String[] args) {
        // SplList.config(true, false, false);  // useful for debugging
        SplList<Person> plist = new SplList();
        plist.printConfig();
        for (Person p : array) {
            plist.insert(p);
        }
        line();

        printlist(plist);


//        // delete don
//        SplList.cursor c = plist.cursor();
//        while (c.hasNext()) {
//            Person p = (Person) c.next();
//            String s = p.toString();
//            if (p.name.equals("don")) {
//                c.remove();
//            }
//        }
//
//        printlist(plist);
    }

    static void line() {
        System.out.println("------------");
    }

    static void printlist(SplList<Person> plist) {
        for (Person l : plist) {
            l.print();
        }
        line();
    }

}
