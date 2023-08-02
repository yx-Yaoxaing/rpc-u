package com.cqnews.rpc.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.cqnews.rpc.definition.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/25 11:36
 */
public class HessianExample {

    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.setName("Hessian");
        student.setId(1L);

        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(bos);
        hessianOutput.writeObject(student);
        byte[] data = bos.toByteArray();

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        HessianInput hessianInput = new HessianInput(bis);
        Student deserializedObject = (Student) hessianInput.readObject();

        System.out.println("原始对象：" + student);
        System.out.println("序列化对象：" + deserializedObject);
    }

}
