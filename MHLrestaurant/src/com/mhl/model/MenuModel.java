package com.mhl.model;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import com.mhl.database.*;
public class MenuModel extends AbstractTableModel{
	Vector Rowdata;
	Vector ColumnsName;
	ResultSet rs;
	ResultSetMetaData rsmt;
	SQLHelper sh;
	public MenuModel()
	{
		sh=new SQLHelper();
	}
	
	public void queryMenu(String sql,String paras[])
	{
		rs=sh.querydb(sql, paras);
		Rowdata=new Vector();
		ColumnsName=new Vector();
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
				Rowdata.add(perdata);
			}
		} catch (SQLException e) {
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
		return Rowdata.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector)Rowdata.get(arg0)).get(arg1);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return ColumnsName.get(column).toString();
	}

}
