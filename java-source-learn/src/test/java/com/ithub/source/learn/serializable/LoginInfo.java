package com.ithub.source.learn.serializable;

import java.io.*;

public class LoginInfo implements Serializable {

    private static final long serialVersionUID = -2504642501120328629L;

    private String name;
    private transient String password;

    public LoginInfo() {
        System.out.println("no parameter constructor");
    }

    public LoginInfo(String name, String password) {
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
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName("AAA");
        loginInfo.setPassword("BBB");
        System.out.println(loginInfo);
        System.out.println("序列化");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("U:\\download\\loginInfo.txt"));
        oos.writeObject(loginInfo);
        oos.close();

        System.out.println("反序列化");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("U:\\download\\loginInfo.txt"));
        LoginInfo _loginInfo = (LoginInfo) ois.readObject();
        System.out.println(_loginInfo);
    }
}
