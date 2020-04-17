package com.ithub.source.learn.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.nio.ByteOrder;

public class ObjectHeadTest {
    private int intValue = 0;
    public static void main(String[] args) {
        ObjectHeadTest object = new ObjectHeadTest();
        //打印hashcode
        System.out.println(object.hashCode());
        //查看字节序
        System.out.println(ByteOrder.nativeOrder());


        //打印当前jvm信息
        System.out.println(VM.current().details());
        String classLayout = ClassLayout.parseInstance(object).toPrintable();
        System.out.println(classLayout);
    }

}
