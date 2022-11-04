package daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import beans.AppointmentBean;
import beans.PatientBean;
import dba.ConnectionProvider;

public class PatientDao {
		
	public static boolean validate(String email,String password){  
		  boolean status=false;
	try {	
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from Patients where email=? and password=?");
		    ps.setString(1,email);  
		    ps.setString(2,password);  
		    	         
	        ResultSet rs=ps.executeQuery();
	        status=rs.next();
	    	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	return status;
}
	
	public static int save(PatientBean pb)	{
		int status=0;
		try	{
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into PATIENTS(id,firstname,age,address,gender,contact,email,password,lastname) values(patient.nextval,?,?,?,?,?,?,?,?)");
		
	        ps.setString(1,pb.getFirstName());
	        ps.setString(2,pb.getAGE());
	        ps.setString(3,pb.getAddress());          
	        ps.setString(4,pb.getGender());  
	        ps.setString(5,pb.getContact());
	        ps.setString(6,pb.getEmail());
	        ps.setString(7,pb.getPassword()); 
	        ps.setString(8,pb.getLastName());
	          
	        status=ps.executeUpdate();  
	          
	        conn.close();  
			}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return status;
	}
	
	 public static List<PatientBean> getAllPatient(){  
	        List<PatientBean> list=new ArrayList<PatientBean>();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Patients ORDER BY id");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                PatientBean pb=new PatientBean();  
	                pb.setId(rs.getInt(1));  
	                pb.setFirstName(rs.getString(2));
	                pb.setAGE(rs.getString(3));
	                pb.setAddress(rs.getString(4));
	                pb.setGender(rs.getString(5));
	                pb.setContact(rs.getString(6)); 
	                pb.setEmail(rs.getString(7));
			        pb.setPassword(rs.getString(8)); 
			        pb.setLastName(rs.getString(9)); 
 					
	                list.add(pb);  
	            }  
	            con.close();  
	        }catch(Exception e){
	        	e.printStackTrace();
	        	}  
	          
	        return list;  
	    }  
	
	
	 
	 
  /*  public static ArrayList<PatientBean> getPatientbyemail(String email)
	 {
	 	ArrayList<PatientBean> list=new ArrayList<>();
	 	try {
	 		Connection con=ConnectionProvider.getConnection();
	 		PreparedStatement ps=con.prepareStatement("select * from Patient where email=? order by firstname ");
	 		ps.setString(1,email);
	 		ResultSet rs=ps.executeQuery();
	 		while (rs.next()) {
	 			PatientBean pb=new PatientBean();
	 				pb.setId(rs.getInt(1));
	 			  	pb.setFirstName(rs.getString(2));  
	 			  	pb.setLastName(rs.getString(3)); 
	                pb.setEmail(rs.getString(4));  
	                pb.setContact(rs.getString(5));
	                pb.setAGE(rs.getString(6));
	                pb.setGender(rs.getString(7));
	                pb.setAddress(rs.getString(8));
	               

	 			list.add(pb);
	 		}
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	 	return list;
	 }*/
	 public static int update(PatientBean up){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ups=con.prepareStatement(  
	                         "update patients set firstname=?,address=?,contact=?,password=? where email=?");  
	            ups.setString(1,up.getFirstName()); 
	            ups.setString(2,up.getAddress());
	            ups.setString(3,up.getContact()); 
	            ups.setString(4,up.getPassword()); 
	            ups.setString(5,up.getEmail());
	            
	            status=ups.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }
	 
	/* public static int newpass(PatientBean np) {
		 int status=0;

			//HttpSession session = request.getSession();
		 
		 try {
			 Connection con=ConnectionProvider.getConnection();  
			 PreparedStatement npa=con.prepareStatement(  
                     "update patients set PASSWORD = ? where EMAIL = ? "); 
			 npa.setString(1,np.getPassword());
			// npa.setString(2, (String) session.getAttribute("email"));

			 
			  status=npa.executeUpdate();
			 con.close();
			 
		 }catch(Exception ex) {ex.printStackTrace();}
		 
		 
		 return status;
		 
	 }*/
	 

}	
