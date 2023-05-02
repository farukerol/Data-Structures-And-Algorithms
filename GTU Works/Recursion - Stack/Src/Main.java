/**
 * Main class for test and run the program.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Test 1");
        SecuritySystem test1 = new SecuritySystem("sibelgulmez","{[(ecarcar)]}");
        test1.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 2");
        SecuritySystem test2 = new SecuritySystem("","(abbaec)");
        test2.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 3");
        SecuritySystem test3 = new SecuritySystem("sibel1","(abbaec}");
        test3.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 4");
        SecuritySystem test4 = new SecuritySystem("gokhan","(baec}");
        test4.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 5");
        SecuritySystem test5 = new SecuritySystem("sibel","abbaec}");
        test5.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 6");
        SecuritySystem test6 = new SecuritySystem("sibel","{}{}[[[]]]");
        test6.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 7");
        SecuritySystem test7 = new SecuritySystem("sibel","[no][no]");
        test7.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 8");
        SecuritySystem test8 = new SecuritySystem("gokhan","{ab[bac]aaba}");
        test8.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 9");
        SecuritySystem test9 = new SecuritySystem("gokhan","{[(abacaba)]}");
        test9.SecurityControl();
        System.out.println("---------------");

        System.out.println("Test 10");
        SecuritySystem test10 = new SecuritySystem("gokhan","{[(abacaba)]))}");
        test10.SecurityControl();
        System.out.println("---------------");

    }
}
