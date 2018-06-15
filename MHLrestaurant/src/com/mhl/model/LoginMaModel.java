package com.mhl.model;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.sql.*;
import com.mhl.database.*;
public class LoginMaModel extends AbstractTableModel{
	Vector RowData;
	Vector ColumnsName;
	ResultSet rs;
	SQLHelper sh;
	ResultSetMetaData rsmt;
	public LoginMaModel()
	{
		sh=new SQLHelper();
	}
	public void queryLogin(String sql,String[] paras )
	{
		//String sql="select r.empid 员工号,r.empname 姓名,r.zhiwei 职位,l.passwd 密码 from rszl r,login l where r.empid=l.empid and 1=?";
		//String paras[]= {"1"};
		rs=sh.querydb(sql, paras);
		ColumnsName=new Vector();
		RowData=new Vector();
		try {
			rsmt=rs.getMetaData();
			for(int i=0;i<rsmt.getColumnCount();i++)
			{
				ColumnsName.add(rsmt.getColumnName(i+1));
			}
			while(rs.next())
			{
				Vector perdata=new Vector();
				for(int j=0;j<rsmt.getColumnCount();j++)
				{
					perdata.add(rs.getObject(j+1));
				}
				RowData.add(perdata);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ColumnsName.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return RowData.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector)RowData.get(arg0)).get(arg1);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.ColumnsName.get(column).toString();
	}
	
}
