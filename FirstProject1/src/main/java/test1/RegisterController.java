package test1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DataManager;
import memberDTO.MemberRegister;


@WebServlet(name = "rc", urlPatterns = { "/rc" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    MemberRegister mr=new MemberRegister();
    DataManager dbm= new DataManager();
    
    public RegisterController() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String detail_address=request.getParameter("detail_address");
		String city=request.getParameter("city");
		String postcode=request.getParameter("postcode");
		
		mr.setName(name);
		mr.setEmail(email);
		mr.setPassword(password);
		mr.setAddress(address);
		mr.setDetail_address(detail_address);
		mr.setCity(city);
		mr.setPostcode(postcode);
		
		//클라로부터 받은 값 MemberRegister에 담아서 메소드 실행
		boolean result=dbm.setMember(mr);
		
		
		
		System.out.println(result);
		
		
	}

}
