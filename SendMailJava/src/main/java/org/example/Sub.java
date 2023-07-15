package org.example;

public class Sub {
    public static String sub;

    public Sub() {
        sub = this.sub;
    }

    public static String getsub() {

       // sub="this is mail regarding class project";
        return sub;
    }

    public static void setsub(String sub) {
        Sub.sub = sub;
    }
}

