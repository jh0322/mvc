package com.example.mvc04.controller;

import com.example.mvc04.model.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberDeleteController implements Controller{

    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));
        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberDelete(num);
        String nextPage = null;
        if (cnt > 0) {
            nextPage = "/memberList.do";
        } else {
            throw new ServletException("not delete");
        }
        return nextPage;
    }
}
