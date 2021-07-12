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
import memberDTO.Member;


@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DataManager dbm=new DataManager();
	
    public SigninServlet() {
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			
			//비밀번호와 이메일이 빈문자열이 아니면
			if(!email.equals("")&&!password.equals("")) {
				
				//로그인
				Member member=dbm.getLoginUser(email,password);
				
				//로그인 성공//이메일,비밀번호 일치
				if(member!=null) {
				
				HttpSession session=request.getSession();
				session.setAttribute("member", member);
				
				//로그인 성공후 프로파일 페이지로 이동
				//RequestDispatcher dispatcher = request.getRequestDispatcher("user_profile.jsp");
				response.sendRedirect("user_profile.jsp");
				
				}else {
					//로그인실패
					System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				}
				
				
			}else {
				//로그인실패
				System.out.println("아이디 또는 비밀번호를 입력해 주세요");
			}
	}

}














