package com.javasm.servlet;

import com.javasm.pojo.MovingBooking;
import com.javasm.service.MovingService;
import com.javasm.service.impl.MovingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-19:49
 * @Since：jdk1.8
 * @Description：
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private MovingService movingService =new MovingServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String add = request.getParameter("address");
        String carType = request.getParameter("carType");
        String moveDate = request.getParameter("moveDate");
        String contact = request.getParameter("contact");
        String phone = request.getParameter("phone");
        MovingBooking mv= new MovingBooking();
        mv.setArea(add);
        mv.setCarType(carType);
        mv.setContact(contact);
        mv.setPhone(phone);
        mv.setMoveDate(moveDate);
        mv.setStatus(0);
        int i = movingService.saveInfoOfClient(mv);


        if(i>0){
            response.getWriter().write("添加成功了!");
        }else {
            response.getWriter().write("添加失败!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
