package com.zumba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zumba.bean.Event;
import com.zumba.bean.Member;
import com.zumba.resource.DbConnection;

public class MemberDao {

	public List<Member> viewAllMember() {
		List<Member> listOfMember = new ArrayList<Member>();
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from member");	
			ResultSet rs1 = pstmt.executeQuery();
			
			while(rs1.next()) {
				Member nm = new Member();
				nm.setMID(rs1.getInt("MID"));
				nm.setF_name(rs1.getString("f_name"));
				nm.setL_name(rs1.getString("l_name"));
				nm.setEmail(rs1.getString("email"));
				listOfMember.add(nm);
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return listOfMember;
	}
	
	public List<Member> viewMembersInEvent(int EID){
		List<Member> membersInEvent = new ArrayList<Member>();
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from member inner join memberEvent on member.MID = memberEvent.MID where EID = (?) ");
			pstmt.setInt(1, EID);
			ResultSet rs2 = pstmt.executeQuery();
			
			while(rs2.next()) {				
				Member nm = new Member();
				nm.setMID(rs2.getInt("MID"));
				nm.setF_name(rs2.getString("f_name"));
				nm.setL_name(rs2.getString("l_name"));
				nm.setEmail(rs2.getString("email"));
				membersInEvent.add(nm);		
			}			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return membersInEvent;
	}
	public Member viewSpecificMember(int MID) {
		Member currentSpecificMember = null;
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from Member where MID = (?)");
			pstmt.setInt(1, MID); 
			ResultSet rs3 = pstmt.executeQuery();
			
			while(rs3.next()) {
				currentSpecificMember = new Member();
				currentSpecificMember.setMID(rs3.getInt("MID"));
				currentSpecificMember.setF_name(rs3.getString("f_name"));
				currentSpecificMember.setL_name(rs3.getString("l_name"));
				currentSpecificMember.setEmail(rs3.getString("email"));
			}		
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return currentSpecificMember;
	}
	
	public void addNewMember(Member newMember) {
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into Member(f_name, l_name, email) values (?,?,?)");
			pstmt.setString(1, newMember.getF_name());
			pstmt.setString(2, newMember.getL_name());
			pstmt.setString(3, newMember.getEmail());
			int intResult = pstmt.executeUpdate(); 
			System.out.println("Member Dao addNewMember=" +intResult);
				
		}catch (Exception e) {
				System.err.println(e.toString());
		}
	}
	public void removeMember(Member member) {
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt1 = con.prepareStatement("delete from MemberEvent where MID = (?)");
			PreparedStatement pstmt2 = con.prepareStatement("delete from Member where MID = (?)");
			pstmt1.setInt(1,member.getMID());
			pstmt2.setInt(1,member.getMID());
			int intResult1 = pstmt1.executeUpdate();
			int intResult2 = pstmt2.executeUpdate();
		}catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}