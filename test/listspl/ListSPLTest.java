
package listspl;

import org.junit.Test;
import SPLList.SplList;


public class ListSPLTest {
    
    public ListSPLTest() {
    }
    
    boolean[] all = {true, false};
    boolean[] t = {true};
    boolean[] f = {false};
    
    static String blank = "_";
    static String testdir = "test/Correct/";
    
  
    @Test
    public void test0() {
        doit(false,false,false);
    }
    
    @Test
    public void test1() {
        doit(false,false,true);
    }
    
    @Test
    public void test2() {
        doit(false,true,false);
    }
    
    @Test
    public void test3() {
        doit(false,true,true);
    }
    
    @Test
    public void test4() {
        doit(true,false,false);
    }
    
    @Test
    public void test5() {
        doit(true,false,true);
    }
    
    @Test
    public void test6() {
        doit(true,true,false);
    }
    
    @Test
    public void test7() {
        doit(true,true,true);
    }
    
    void doit(boolean d, boolean s, boolean sg) {
        RegTest.Utility.redirectStdOut("out.txt");
        SplList.config(d, s, sg);
        String testname = d + blank + s + blank + sg +".txt";
        Main.main(null);
        RegTest.Utility.validate("out.txt", testdir+testname, true);
    }
    
}
