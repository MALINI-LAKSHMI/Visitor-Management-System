package com.wipro.visitor.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.visitor.bean.VisitorBean;
import com.wipro.visitor.util.DBUtil;

public class VisitorDAO {

   
    public String generateVisitorID(String visitorName, Date visitDate) {

        String visitorId = null;

        try (Connection con = DBUtil.getDBConnection();
             Statement st = con.createStatement()) {

            ResultSet rs =
                st.executeQuery("SELECT VISITOR_SEQ.NEXTVAL FROM DUAL");

            if (rs.next()) {

                int seq = rs.getInt(1);

                SimpleDateFormat sdf =
                        new SimpleDateFormat("yyyyMMdd");

                String datePart = sdf.format(visitDate);

                String namePart =
                        visitorName.substring(0, 2).toUpperCase();

                visitorId = datePart + namePart + seq;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return visitorId;
    } 

    
    public String createRecord(VisitorBean bean) {

        String sql =
        "INSERT INTO VISITOR_TB VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bean.getVisitorId());
            ps.setString(2, bean.getVisitorName());
            ps.setString(3, bean.getPurpose());
            ps.setDate(4, bean.getVisitDate());
            ps.setString(5, bean.getContactNo());
            ps.setString(6, bean.getRemarks());

            int result = ps.executeUpdate();

            if (result > 0)
                return bean.getVisitorId();

        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();   
        }

        return "FAIL";
    }

    
    public boolean recordExists(String visitorName,
                                Date visitDate) {

        String sql =
        "SELECT * FROM VISITOR_TB WHERE VISITORNAME=? AND VISITDATE=?";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ps.setString(1, visitorName);
            ps.setDate(2,
              new java.sql.Date(visitDate.getTime()));

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

   
    public VisitorBean fetchRecord(String visitorName,
                                    Date visitDate) {

        VisitorBean bean = null;

        String sql =
        "SELECT * FROM VISITOR_TB WHERE VISITORNAME=? AND VISITDATE=?";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps =
                con.prepareStatement(sql)) {

            ps.setString(1, visitorName);
            ps.setDate(2,
              new java.sql.Date(visitDate.getTime()));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                bean = new VisitorBean();

                bean.setVisitorId(rs.getString(1));
                bean.setVisitorName(rs.getString(2));
                bean.setPurpose(rs.getString(3));
                bean.setVisitDate(rs.getDate(4));
                bean.setContactNo(rs.getString(5));
                bean.setRemarks(rs.getString(6));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    public List<VisitorBean> fetchAllRecords() {

        List<VisitorBean> list =
                new ArrayList<>();

        String sql = "SELECT * FROM VISITOR_TB";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps =
                 con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                VisitorBean bean =
                        new VisitorBean();

                bean.setVisitorId(rs.getString(1));
                bean.setVisitorName(rs.getString(2));
                bean.setPurpose(rs.getString(3));
                bean.setVisitDate(rs.getDate(4));
                bean.setContactNo(rs.getString(5));
                bean.setRemarks(rs.getString(6));

                list.add(bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}