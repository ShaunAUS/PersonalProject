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


@WebServlet(name = "cp", urlPatterns = { "/cp" })
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DataManager dbm=new DataManager();
    public ChangePassword() {
     
    }

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("passReset.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String newPassword=request.getParameter("newPassword");
		String newPasswordConfirm=request.getParameter("newPasswordConfirm");
		
		
		int changeResult=dbm.changePass("newPassword");
		
		if(changeResult==1) {
		System.out.println("비밀번호 변경 성공");
		}else {
			System.out.println("비밀번호 변경 실패");
		}
		
	}

}
