package daofiles;	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dba.ConnectionProvider;
import beans.DocBean;
import beans.intimateBean;

public class DoctorDao {
	
	public static boolean validate(String email,String password){  
		  boolean status=false;
	try {	
			Connection conn=ConnectionProvider.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from doctors where email=? and password=?");
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
	
	 public static int save(DocBean db){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into doctors(id,docname,dob,doj,gender,qualification,yearsofexperience,address,email,password,specialty,contact) values(docseq.nextval,?,?,?,?,?,?,?,?,?,?,?)");  
	            
	            ps.setString(1,db.getDocname());
	            ps.setString(2,db.getDob());
	            ps.setString(3,db.getDoj());
	            ps.setString(4,db.getGender());
	            ps.setString(5,db.getQualification());
	            ps.setString(6,db.getExperience());
	            ps.setString(7,db.getAddress());
	            ps.setString(8,db.getEmail());
	            ps.setString(9,db.getPassword());              
	            ps.setString(10,db.getSpecialty());  
	            ps.setString(11,db.getContact());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        {ex.printStackTrace();}  
	          
	        return status;  
	    }  
	 public static int update(DocBean doc){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update doctors set docname=?,password=?,contact=?,dob=?,doj=?,gender=?,qualification=?,YEARSOFEXPERIENCE=?,address=? where email=?");  
	            ps.setString(1,doc.getDocname()); 
	            ps.setString(2,doc.getPassword());   
	            ps.setString(3,doc.getContact());
	            ps.setString(4,doc.getDob());
	            ps.setString(5,doc.getDoj());
	            ps.setString(6,doc.getGender());
	            ps.setString(7,doc.getQualification());
	            ps.setString(8,doc.getExperience());
	            ps.setString(9,doc.getAddress());
	            ps.setString(10,doc.getEmail()); 
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from doctors where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static DocBean getDoctor(int id,String email){  
	        DocBean dbe=new DocBean();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from Doctors where id=? and email=?");  
	            ps.setInt(1,id);  
	            ps.setString(2,email);
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                
	                dbe.setId(rs.getInt(1));  
	                dbe.setDocname(rs.getString(2));  
	                dbe.setDob(rs.getString(3));
	                dbe.setDoj(rs.getString(4));
	                dbe.setGender(rs.getString(5));
	                dbe.setQualification(rs.getString(6));
 	                dbe.setExperience(rs.getString(7));
 	                dbe.setAddress(rs.getString(8));
 	                dbe.setEmail(rs.getString(9));
   			        dbe.setPassword(rs.getString(10)); 	
	                dbe.setSpecialty(rs.getString(11));
    				dbe.setContact(rs.getString(12)); 	
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return dbe;  
	    }  
	    public static List<DocBean> getAllDoctors(){  
	        List<DocBean> list=new ArrayList<DocBean>();  
	          
	        try{  
	            Connection con=ConnectionProvider.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from doctors ORDER BY id");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                DocBean db=new DocBean();  
	                db.setId(rs.getInt(1));  
	                db.setDocname(rs.getString(2));  
	                db.setDob(rs.getString(3));
	                db.setDoj(rs.getString(4));
	                db.setGender(rs.getString(5));
	                db.setQualification(rs.getString(6));
 	                db.setExperience(rs.getString(7));
 	                db.setAddress(rs.getString(8));
 	                db.setEmail(rs.getString(9));
   			        db.setPassword(rs.getString(10)); 	
	                db.setSpecialty(rs.getString(11));
    				db.setContact(rs.getString(12)); 	
	                list.add(db);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	    
	  
	    
	    
}
