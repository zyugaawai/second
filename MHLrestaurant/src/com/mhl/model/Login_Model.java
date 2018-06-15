package com.mhl.model;
import java.sql.*;
import com.mhl.database.*;
public class Login_Model {
	String job;
	ResultSet rs;
	SQLHelper sh;
	public String checklogin(String sql,String[] paras)
	{
		sh=new SQLHelper();
		rs=sh.querydb(sql, paras);
		try {
			if(rs.next())
			{
				job=rs.getString(1);
			}else {
				job="Œﬁ¥À»À";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sh.close();
		}
		
		return job;
	}
}
