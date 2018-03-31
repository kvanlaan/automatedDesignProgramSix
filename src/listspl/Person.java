package listspl;


public class Person implements SPLList.SplListKey {
    public String name;
    public int age;
    public int salary;
    public String city;
    
    Person(String n, int a, int s, String c) {
        name = n;
        age= a;
        salary = s;
        city = c;
    }
    
    public int getKey() {
        return age;
    }
    
    public String toString() {
        return String.format("person(%5s,%3d,%3d,%s).", name, age, salary, city);
    }
    
    public void print() {
        System.out.println(this);
    }
}
