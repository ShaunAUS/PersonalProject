package test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DataManager;



@WebServlet(name = "fp", urlPatterns = { "/fp" })
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DataManager dbm=new DataManager();
	
    public ForgotPasswordServlet() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String forgotPassword_email=request.getParameter("forgotPassword_email");
		
		
		
		//이메일로 계정있나 확인
		if(!forgotPassword_email.equals("")&&forgotPassword_email!=null) { 
			
			String ResultcheckEmail=dbm.checkEmail(forgotPassword_email);
			
			HttpSession session=request.getSession();
			session.setAttribute("Result", ResultcheckEmail);
			
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("passReset.jsp");
			//비밀번호 바꾸는 화면으로 넘기기
			response.sendRedirect("passReset.jsp");		
			
		
	}

	}
	}
