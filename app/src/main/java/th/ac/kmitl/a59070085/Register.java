package th.ac.kmitl.a59070085;

import android.content.ContentValues;

public class Register {
    ContentValues row;

    String user;
    String name;
    int age;
    String password;

    public Register(String user, String name, int age, String password) {
        this.user = user;
        this.name = name;
        this.age = age;
        this.password = password;

        row.put("user", user);
        row.put("name", name);
        row.put("age", age);
        row.put("password", password);
    }

    ContentValues getRow(){
        return row;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
