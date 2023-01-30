package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.iu.home.util.DBConnection;

public class MemberDAO {
	//setAddMember
	private Scanner sc;
	
	public MemberDAO() {
		this.sc = new Scanner(System.in);
	}
	
	
	public int setAddMember(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql ="INSERT INTO MEMBER(ID, Pw, NAME, ADDRESS, PHONE, EMAIL) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,memberDTO.getId());
		st.setString(2,memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getAddress());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			
			MemberDTO dto = new MemberDTO();
			
			dto.setId("id1");
			dto.setPw("pw1");
			dto.setName("name1");
			dto.setAddress("address1");
			dto.setPhone("phone1");
			dto.setEmail("Email1");
			
			int a = dao.setAddMember(dto);
			
			System.out.println(a ==1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
