package com.wipro.visitor.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.wipro.visitor.bean.VisitorBean;
import com.wipro.visitor.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String operation = request.getParameter("operation");

            if (operation == null) {
                response.getWriter().println("Invalid Action");
                return;
            }

            Administrator admin = new Administrator();

            // ADD RECORD
            if (operation.equals("newRecord")) {

                VisitorBean bean = new VisitorBean();

                bean.setVisitorName(request.getParameter("visitorName"));
                bean.setPurpose(request.getParameter("purpose"));
                bean.setContactNo(request.getParameter("contactNo"));
                bean.setRemarks(request.getParameter("remarks"));

                String dateStr = request.getParameter("visitDate");

                SimpleDateFormat sdf =
                        new SimpleDateFormat("yyyy-MM-dd");

                Date date = sdf.parse(dateStr);
                bean.setVisitDate(date);

                String result = admin.addRecord(bean);

                if (result.equals("FAIL") || result.contains("INVALID")) {
                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("success.html");
                }
            }
            else if (operation.equals("viewRecord")) {

                String name = request.getParameter("visitorName");
                String dateStr = request.getParameter("visitDate");

                SimpleDateFormat sdf =
                        new SimpleDateFormat("yyyy-MM-dd");

                Date date = sdf.parse(dateStr);

                VisitorBean bean = admin.viewRecord(name, date);

                request.setAttribute("visitor", bean);

                RequestDispatcher rd =
                        request.getRequestDispatcher("displayVisitor.jsp");

                rd.forward(request, response);
            }

            // VIEW ALL RECORDS
            else if (operation.equals("viewAllRecords")) {

                request.setAttribute("visitorList",
                        admin.viewAllRecords());

                RequestDispatcher rd =
                        request.getRequestDispatcher("displayAllVisitors.jsp");

                rd.forward(request, response);
            }

            else {
                response.getWriter().println("Invalid Action");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

