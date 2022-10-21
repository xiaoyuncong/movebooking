package com.javasm.pojo;

import com.sun.org.apache.xpath.internal.objects.XString;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-17:50
 * @Since：jdk1.8
 * @Description：
 */
public class MovingBooking {

    private Integer id;

    private String area;

    private String carType;

    private String moveDate;

    private String contact;

    private String phone;

    private Integer status;

    @Override
    public String toString() {
        return "MovingBooking{" + "id=" + id + ", area='" + area + '\'' + ", carType='" + carType + '\'' + ", moveDate='" + moveDate + '\'' + ", contact='" + contact + '\'' + ", phone='" + phone + '\'' + ", status=" + status + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(String moveDate) {
        this.moveDate = moveDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        if(this.status==0){
            return "未处理";
        }else if(this.status==1){
            return "已处理";
        }else {
            return "已完结";
        }

    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
