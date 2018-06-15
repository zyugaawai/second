package com.mhl.model;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import com.mhl.database.*;
public class HRManagerModel extends AbstractTableModel{
	Vector ColumnNames;
	Vector RowData;
	ResultSet rs=null;
	SQLHelper sh=null;
	ResultSetMetaData rsmt;
	//查询
	public void queryHRManger(String sql,String paras[])
	{
		RowData=new Vector();
		ColumnNames=new Vector();
		sh=new SQLHelper();
		rs=sh.querydb(sql, paras);
		try {
			//从rs对象中可以得到一个ResultSetMetadata
			rsmt=rs.getMetaData();
			for(int i=0;i<rsmt.getColumnCount();i++)
			{
				ColumnNames.add(rsmt.getColumnName(i+1));
			}
			while(rs.next())
			{
				Vector perData=new Vector();
				for(int j=0;j<rsmt.getColumnCount();j++)
				{
					perData.add(rs.getString(j+1));
				}
				RowData.add(perData);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sh.close();
		}
	}
	
	//增加
	public boolean addemp(String paras[],java.util.Date date1,java.util.Date date2)
	{
		boolean b;
		
		String sql="insert into rszl (empid,empname,sex,address,birthday,sfzid,xl,zhiwei,hf,tel1,tel2,mail,zctime,bz) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		sh=new SQLHelper();
		b=sh.Updatedb(sql, paras,date1,date2);
		
		return b;
	}
	
	//删除
	public boolean deleteemp(String empid)
	{
		boolean b;
		
		String sql="delete from rszl where empid=?";
		String paras[]= {empid};
		sh=new SQLHelper();
		b=sh.Updatedb(sql, paras,null,null);
		
		return b;
	}
	
	//改
	public boolean updateemp(String paras[])
	{
		boolean b;
		
		String sql="update rszl set empname=?,sex=?,address=?,sfzid=?,xl=?,zhiwei=?"
				+ ",hf=?,tel1=?,tel2=?,mail=?,bz=? where empid=?";
		sh=new SQLHelper();
		b=sh.Updatedb(sql, paras,null,null);
		
		return b;
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ColumnNames.size();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return RowData.size();
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector)(RowData.get(arg0))).get(arg1);
	}
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)(this.ColumnNames.get(column));
    }
}
