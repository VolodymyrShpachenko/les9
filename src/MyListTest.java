import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) {

        MyArrayList <String> ml = new MyArrayList<>(4);
        String s1 = "s";
        String s2 = "t";
        String s3 = "r";
        String s4 = "i";
        String s5 = "n";
        String s6 = "g";
        ml.add(s1);
        ml.add(s2);
      //  System.out.println(ml);
        ml.add(s3);
        ml.add(s4);
     //   System.out.println(ml);
        ml.add(s5);
        ml.add(s6);
     //   System.out.println(ml);
       // System.out.println(ml.get(3));
        ml.remove(4);
        System.out.println(ml);
        ml.remove(4);
        System.out.println(ml);

        System.out.println(ml.get(9));


//        ArrayList<String> list = new ArrayList<>();
//        String s1 = new String("s");
//        list.add(s1);
    }
}