package com.mhl.database;
import java.sql.*;
import java.util.*;
public class SQLHelper {
	String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	String url="jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=RestaurantDB";
	String user="sa";
	String password="123";
	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	public SQLHelper()
	{
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,user,password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet querydb(String sql,String[] paras)
	{
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean Updatedb(String sql,String[] paras,java.util.Date date1,java.util.Date date2)
	{
		boolean b=true;
		
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++)
			{
				ps.setString(i+1, paras[i]);
			}
			if(date1!=null)
			{
				 ps.setDate(5, new java.sql.Date (date1.getTime()));
			}
			if(date2!=null)
			{
				ps.setDate(13, new java.sql.Date (date2.getTime()));
			}
			
			if(ps.executeUpdate()!=1)
			{
				b=false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b=false;
		}finally {
			this.close();
		}
		
		return b;
	}
	
	public void close()
	{
		try {
			if(rs!=null)
			{
				rs.close();
			}
			if(ps!=null)
			{
				ps.close();
			}
			if(ct!=null)
			{
				ct.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
