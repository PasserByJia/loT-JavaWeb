package cn.jh.loTWeb.controller;

import cn.jh.loTWeb.domain.Item;
import cn.jh.loTWeb.service.ItemService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/getData")
public class GetDataController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Item item = ItemService.getInstance().find(id);
            String json =JSONObject.toJSONString(item);
            PrintWriter out = response.getWriter();
            //响应输出数据
            out.print(json);
            out.flush();
            out.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
