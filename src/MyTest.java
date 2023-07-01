public class MyTest {
    public static void main(String[] args) {
        MyHashMap <Integer, String> mhm = new MyHashMap<>();
        String s1 = "one";
        String s2 = "two";
        String s3 = "three";
        String s4 = "four";
        String s5 = "five";
        String s6 = "six";
        //System.out.println(mhm);
        //System.out.println(mhm.poll());
        mhm.put(1, s1);
        mhm.put(2, s2);
        mhm.put(3, s3);
//       // System.out.println(mhm);
//        mhm.put(4, s4);
        mhm.put(5, s5);
        mhm.put(6, s6);
        System.out.println(mhm);
       // System.out.println(mhm.poll());
        //System.out.println(mhm.size());
       // System.out.println(mhm.peek());
      //  mhm.clear();
        System.out.println(mhm.get(10));

    }
}