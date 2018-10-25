package cn.jh.loTWeb.controller;

import cn.jh.loTWeb.domain.Item;
import cn.jh.loTWeb.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class DataUpdateController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        try {
            double temperature = Double.parseDouble(request.getParameter("t"));
            double humidity = Double.parseDouble(request.getParameter("h"));
            double weight = (Double.parseDouble(request.getParameter("w"))>0)?Double.parseDouble(request.getParameter("w")): -Double.parseDouble(request.getParameter("w"));
            int infaredSensor = Integer.parseInt(request.getParameter("i"));
            int id = Integer.parseInt(request.getParameter("id"));
            Item item = new Item(id,temperature,humidity,weight,infaredSensor);
            ItemService.getInstance().update(item);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
