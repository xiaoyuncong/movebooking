package com.javasm.pojo;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-17:48
 * @Since：jdk1.8
 * @Description：
 */


public class Users {
    private Integer id;
    private String name;
    private String password;


    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
