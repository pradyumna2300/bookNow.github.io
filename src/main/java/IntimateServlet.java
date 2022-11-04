

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.intimateBean;
import daofiles.IntimateDao;

/**
 * Servlet implementation class AppointmentReg
 */
@WebServlet("/IntimateServlet")
public class IntimateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntimateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		   out.println("<html>");
		   out.println("<head>");
	       out.println("<title>Book Appointment</title>");
	       out.println("</head>");
	       out.print("<body>");  	
	  	       
			String email=request.getParameter("email");
			String date =request.getParameter("date");
			
			intimateBean ab =new intimateBean();
			
			ab.setEmail(email);
			ab.setDate(date);
			
			
			 int status=IntimateDao.save(ab);  
		        if(status>0){  
		            request.getRequestDispatcher("ReportIntimate.jsp").forward(request, response);  
		        }else{  
		            out.println("Sorry! unable to save record");  
		        }  
		          
		        out.close();  
		    			
			out.print("</body>");
			out.print("</html>");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
