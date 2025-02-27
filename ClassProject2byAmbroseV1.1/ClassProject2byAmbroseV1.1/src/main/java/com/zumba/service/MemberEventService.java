package com.zumba.service;
import com.zumba.dao.MemberEventDao;
import com.zumba.bean.Member;
import com.zumba.bean.MemberEvent;

public class MemberEventService {
	MemberEventDao med = new MemberEventDao();
	
	
	
	public void addMemberToEvent(MemberEvent newMemberEvent) {
		med.addMemberToEvent(newMemberEvent);
	}
	public void removeMemberFromEvent(MemberEvent MemberEvent) {
		med.removeMemberFromEvent(MemberEvent);
	}
}
