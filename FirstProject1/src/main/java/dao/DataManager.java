package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import memberDTO.Member;
import memberDTO.MemberRegister;

public class DataManager extends blogDAO {
	
	Member member=new Member();
	MemberRegister mr =new MemberRegister();
	blogDAO bd=new blogDAO();
	
	

	//비밀번호 ->새 비밀번호
	public int changePass(String newPassword) {
		
		
		HttpSession session=null;
		Connection conn = null;            // 데이터베이스 연결정보 
		PreparedStatement pstmt = null;    // SQL 관리정보 
		int result = 0;             // 검색결과 
		
		
		//세션에 저장된 이메일 불러오기 
		
		
		 
			session.getAttribute("Result");
	
		
		//비밀번호 바꿈
		String sql = "UPDATE memeber_master2 SET password=? WHERE email=?";
				
		
		try {
			
			
			conn = bd.getConnection();

			pstmt = conn.prepareStatement(sql);	 
			pstmt.setString(1,newPassword);
			pstmt.setString(2,"Result");
			
			result = pstmt.executeUpdate();

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
			
			close(pstmt);
			close(conn);
		}
		return result;
	
	}
		
	
	
	//이메일로 정보 있나확인
	public String checkEmail(String forgotPassword_email) {
		
	
		Connection conn = null;            // 데이터베이스 연결정보 
		PreparedStatement pstmt = null;    // SQL 관리정보 
		ResultSet rset= null;
		String mailCheck =null;;
		
		//이메일로 계정확인
		String sql = "SELECT email FROM member_master2 WHERE email=?";
				
		
		try {
			
			conn = bd.getConnection();
			pstmt = conn.prepareStatement(sql);	 
			pstmt.setString(1,forgotPassword_email);
			
			
			 rset= pstmt.executeQuery();
			
			//이메일과 일치하는 계정 있는경우
			
			if(rset.next()) {
				
				mailCheck=rset.getString("email");
				
				
				
			}else {
				System.out.println("이메일에 해당 되는 정보가 없습니다");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
			close(rset);
			close(pstmt);
			close(conn);
		}
		return mailCheck;
	}
	//로그인	
	public Member getLoginUser(String email, String password) {
		
		
		Connection conn = null;            // 데이터베이스 연결정보 
		PreparedStatement pstmt = null;    // SQL 관리정보 
		ResultSet rset = null;             // 검색결과 
		
		String sql = "SELECT * FROM member_master2 WHERE email=? AND password=?";
		 
		
		try {
			
			conn = bd.getConnection();

			pstmt = conn.prepareStatement(sql);	 
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			rset = pstmt.executeQuery();

			// 로그인 성공 //검색결과 있으면// 그에 해당하는 정보 다가져온다 
			if (rset.next()) {
				
				member.setMemberIdx(rset.getInt(1));
				member.setName(rset.getString(2));
				member.setPassword(rset.getString(3));
				member.setEmail(rset.getString(4));
				member.setContact(rset.getString(5));
				member.setContact_phone(rset.getString(6));
				member.setAddress(rset.getString(7));
			}else {
				member=null;
			}
				
			
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
			close(rset);
			close(pstmt);
			close(conn);
		}

		return member;
	}
	
	
	
	
	//회원가입
	public boolean setMember(MemberRegister mr) {
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		boolean result = false;
		
		
		try {
			
			conn = bd.getConnection();

			
			String sql = "INSERT INTO member_register(name,email,password,address,detail_address,city,postcode) VALUES(?, ?, ?, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1,mr.getName());
			pstmt.setString(2,mr.getEmail());
			pstmt.setString(3,mr.getPassword());
			pstmt.setString(4,mr.getAddress());
			pstmt.setString(5,mr.getDetail_address());
			pstmt.setString(6,mr.getCity());
			pstmt.setString(7,mr.getPostcode());
			
			
			
			//쿼리문 성공 //true반환
			int cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 
			close(pstmt);
			close(conn);
		}

		return result;  //등록성공시 true반환
	}
}
