
public class MyStaticCheck{

    public static final String URL = "123"; // Noncompliant

    private static final String URL2 = "hhhh/hhhh";

    public static final Integer URL3 = 22;

    public static void main(String[] args){

    }

    public static void test(Object obj){

    }

    public void test2(java.util.List list){

    }

}