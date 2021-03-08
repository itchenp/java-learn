package com.ithub.source.learn.serializable;

import java.io.*;

public class LoginInfo2 implements Externalizable {

    private static final long serialVersionUID = -2504642501120328629L;

    private String name;
    // transient 在 Externalizable 中失效
    private transient String password;

    public LoginInfo2() {
        System.out.println("no parameter constructor");
    }

    public LoginInfo2(String name, String password) {
        System.out.println("parameter constructor");
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LoginInfo2 loginInfo = new LoginInfo2();
        loginInfo.setName("AAA");
        loginInfo.setPassword("BBB");
        System.out.println(loginInfo);
        System.out.println("序列化");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("U:\\download\\loginInfo2.txt"));
        oos.writeObject(loginInfo);
        oos.close();

        System.out.println("反序列化");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("U:\\download\\loginInfo2.txt"));
        LoginInfo2 _loginInfo = (LoginInfo2) ois.readObject();
        System.out.println(_loginInfo);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        password = in.readUTF();
    }
}
