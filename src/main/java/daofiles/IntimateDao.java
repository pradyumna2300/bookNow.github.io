package daofiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.DocBean;
import beans.intimateBean;
import dba.ConnectionProvider;

public class IntimateDao {
		
	 public static int save(intimateBean ab){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  		//	Sequence = appoint 
	            PreparedStatement ps=con.prepareStatement("insert into intimate values(?,?)");
	            
	          
	            ps.setString(1,ab.getEmail());
	            ps.setString(2,ab.getDate());
	           
	            
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        {ex.printStackTrace();}  
	          
	        return status;  
	    }//SELECT Employee_id,Employee_name, Employee_DOB, Department_Name
	 //FROM #Employees LEFT JOIN #Departments
   //  ON #Departments.Department_id = #Employees.Department_ID
	  public static List<intimateBean> getleaveDoctors(){  
	        List<intimateBean> list=new ArrayList<intimateBean>();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * FROM INTIMATE");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                intimateBean db=new intimateBean();  
	               
	                db.setEmail(rs.getString(1));
 			        
	                
  				    db.setDate(rs.getString(2));
	                list.add(db);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	  public static List<DocBean> getlDoctors(){  
	        List<DocBean> list=new ArrayList<DocBean>();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from  doctors,intimate where "+
	 					"doctors.email=intimate.email");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                DocBean db=new DocBean();  
	               
	                db.setId(rs.getInt(1));
			        db.setDocname(rs.getString(2));
	                db.setEmail(rs.getString(3));
				    db.setDate(rs.getString("LEAVEDATE"));
				    
	                list.add(db);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  


}
