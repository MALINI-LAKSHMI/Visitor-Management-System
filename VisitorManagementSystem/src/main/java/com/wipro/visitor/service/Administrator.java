package com.wipro.visitor.service;

import java.util.Date;

import com.wipro.visitor.bean.VisitorBean;
import com.wipro.visitor.dao.VisitorDAO;

public class Administrator {

    public String addRecord(VisitorBean bean) {

        try {

            if(bean == null ||
               bean.getVisitorName() == null ||
               bean.getPurpose() == null ||
               bean.getContactNo() == null ||
               bean.getVisitDate() == null)
                return "INVALID INPUT";

            if(bean.getVisitorName().length() < 2)
                return "INVALID VISITOR NAME";

            if(bean.getPurpose().length() < 2)
                return "INVALID PURPOSE";

            if(bean.getContactNo().length() < 10)
                return "INVALID CONTACT NUMBER";

            VisitorDAO dao = new VisitorDAO();

            if(dao.recordExists(bean.getVisitorName(),
                                bean.getVisitDate()))
                return "ALREADY EXISTS";

            String id =
                dao.generateVisitorID(bean.getVisitorName(),
                                      bean.getVisitDate());

            bean.setVisitorId(id);

            return dao.createRecord(bean);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return "FAIL";
    }

	public Object viewAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	public VisitorBean viewRecord(String name, Date date) {
		// TODO Auto-generated method stub
		return null;
	}
}