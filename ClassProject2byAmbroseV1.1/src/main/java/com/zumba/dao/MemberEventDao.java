package com.zumba.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zumba.bean.Member;
import com.zumba.bean.Event;
import com.zumba.bean.MemberEvent;
import com.zumba.resource.DbConnection;

public class MemberEventDao {

	public void addMemberToEvent(MemberEvent newMemberEvent) {
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into MemberEvent(EID, MID) values (?,?)");
			pstmt.setInt(1, newMemberEvent.getEID());
			pstmt.setInt(2, newMemberEvent.getMID());
			int intResult = pstmt.executeUpdate(); 
			System.out.println("MemberEvent Dao addNewMemberEvent=" +intResult);
				
		}catch (Exception e) {
				System.err.println(e.toString());
		}
	}
	public void removeMemberFromEvent(MemberEvent MemberEvent) {
		try {
			Connection con = DbConnection.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from MemberEvent(EID, MID) values (?,?)");
			pstmt.setInt(1, MemberEvent.getEID());
			pstmt.setInt(2, MemberEvent.getMID());
			int intResult = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}