package Insertdata;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_GYM_Managment extends Thread{
    public static void insert(Connection con,int choice,Scanner s) throws SQLException {
    	System.out.println("Enter Name Of Member:->");
		String name=s.next();
		System.out.println("Enter memberShip(monthly,yearly):->");
		String memebrship=s.next();
		System.out.println("Enter Start date:->");
		String start=s.next();
		System.out.println("Enter End date:->");
		String End=s.next();
		System.out.println("Enter Fee date:->");
		int fee=s.nextInt();
		System.out.println("payment (pending)(done):->");
		String payment=s.next();
		PreparedStatement ps=con.prepareStatement("insert into member(name,m_type,start_date,end_date,fee,payment) values(?,?,?,?,?,?)");
	    ps.setString(1, name);
	    ps.setString(2,memebrship );
	    ps.setString(3, start);
	    ps.setString(4, End);
	    ps.setInt(5, fee);
	    ps.setString(6, payment);
        ps.execute();
        System.out.println("Data has Been Inserted..");
    }
    public static void view(Connection con,int choice,Scanner s) throws SQLException {
		CallableStatement cb=con.prepareCall("select * from member");
		ResultSet rs=cb.executeQuery();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Id\tName\t\tM_Type\tstart_date\tEnd_date\tFee\t\tPayement\tstatus");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+"\t"+rs.getString(3)+"\t"+"\t"+rs.getString(4)+"\t"
					+"\t"+rs.getString(5)+"\t"+"\t"+rs.getInt(6)+"\t"+"\t"+rs.getString(7)+"\t");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
    }
    
    
    public static void update(Connection con,int choice,Scanner s) throws SQLException {

    System.out.println("Enter The Id:->");
	int id=s.nextInt();
    System.out.println("Enter The Choice for update:->");
    System.out.println("1.Name");
    System.out.println("2.Memebership");
    System.out.println("3.Start_Date");
    System.out.println("4.End_Date");
    System.out.println("5.Fee");
    System.out.println("5.Pending payment");
    System.out.println("(1-5)-->");
    int ch=s.nextInt();
    if(ch==1) {
		System.out.println("Enter Name Of Member:->");
	String name=s.next();
	PreparedStatement pl=con.prepareStatement("update member set name='"+name+"' where id="+id);
	pl.execute();
	System.out.println("Data Has been updated...");
    }else if(ch==2) {
	System.out.println("Enter memberShip(monthly,yearly):->");
	String memebrship=s.next();
	PreparedStatement pl=con.prepareStatement("update member set m_type='"+memebrship+"' where id="+id);
	pl.execute();
	System.out.println("Data Has been updated...");
    }else if(ch==3) {
	System.out.println("Enter Start date:->");
	String start=s.next();
	PreparedStatement pl=con.prepareStatement("update member set start_date='"+start+"' where id="+id);
	pl.execute();
	System.out.println("Data Has been updated...");
    }else if(ch==4) {
	System.out.println("Enter End date:->");
	String End=s.next();
	PreparedStatement pl=con.prepareStatement("update member set end_date='"+End+"' where id="+id);
	pl.execute();
	System.out.println("Data Has been updated...");
    }else if(ch==5) {
	System.out.println("Enter Fee date:->");
	int fee=s.nextInt();
	PreparedStatement pl=con.prepareStatement("update member set fee="+fee+" where id="+id);
	pl.execute();
	System.out.println("Data Has been updated...");
    }else if(ch==6) {
	System.out.println("payment (pending)(done):->");
	String payment=s.next();
	PreparedStatement pl=con.prepareStatement("update member set fee="+payment+" where id="+id);
	pl.execute();
	System.out.println("Data Has been updated...");
    }
    }
    
    public static void delete(Connection con,int choice,Scanner s) throws SQLException {
		System.out.println("Enter The Id:->");
		int id=s.nextInt();
		PreparedStatement pw=con.prepareStatement("delete from member where id="+id);
		pw.execute();
		System.out.println("data has been deleted!!");
    }
    
    
    public static void Search(Connection con,int choice,Scanner s) throws SQLException {
  		System.out.println("Enter The Name For Search:->");
		String name=s.next();
		CallableStatement cb=con.prepareCall("select * from member where name='"+name+"'");
    		ResultSet  rs=cb.executeQuery();
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println("Id\tName\t\tM_Type\tstart_date\tEnd_date\tFee\tPayement\tSataus");
		System.out.println("-------------------------------------------------------------------------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+"\t"+rs.getString(3)+"\t"+"\t"+rs.getString(4)+"\t"
					+"\t"+rs.getString(5)+"\t"+"\t"+rs.getInt(6)+"\t"+"\t"+rs.getString(7)+"\t");
		}
		System.out.println("-------------------------------------------------------------------------------------------------");
		 
    }
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/delta","root","12345");
        String str1="==========GYM_MANAGMENT MENU=============";
        String str2="1.Insert";
        String str3="2.View";
        String str4="3.Update";
        String str5="4.Delete";
        String str6="5.Search";
        String str7="=========================================";
        int choice=1;
        while(choice!=0) {
        for(int i=0;i<str1.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str1.charAt(i));
        }
    	System.out.println();
        for(int i=0;i<str2.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str2.charAt(i));
        }
    	System.out.println();
        for(int i=0;i<str3.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str3.charAt(i));
        }
    	System.out.println();
        for(int i=0;i<str4.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str4.charAt(i));
        }
    	System.out.println();
        for(int i=0;i<str5.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str5.charAt(i));
        }
    	System.out.println();
        for(int i=0;i<str6.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str6.charAt(i));
        }
    	System.out.println();
        for(int i=0;i<str7.length();i++) {
        	Thread.sleep(80);
        	System.out.print(str7.charAt(i));
        }
    	System.out.println("\n(1-5) (0 for exit:->");
    	Scanner s=new Scanner(System.in);
    	choice=s.nextInt();
    	switch(choice) {
    	case 1:
    		JDBC_GYM_Managment.insert(con, choice, s);
            break;
    	case 2:
    		JDBC_GYM_Managment.view(con, choice, s);
            break;
    	case 3:
    		JDBC_GYM_Managment.update(con, choice, s);

            break;
    	case 4:
    		JDBC_GYM_Managment.delete(con, choice, s);
            break;
    	case 5:
    		JDBC_GYM_Managment.Search(con, choice, s);
            break;
         default:
        	System.out.println("Logout SuccessFully !!!");
    	 }
       }
	}
}
