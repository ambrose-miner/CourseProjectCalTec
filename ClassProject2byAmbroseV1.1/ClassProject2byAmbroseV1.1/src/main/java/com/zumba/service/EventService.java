package com.zumba.service;

import java.util.List;

import com.zumba.bean.Event;
import com.zumba.dao.EventDao;

public class EventService {

 private EventDao ed = new EventDao();
	
	
		public List<Event> viewAlleventDetails() {
			return ed.viewAllevent(); 
		}
		
		public List<Event> viewEventsForMember(int MID) {
			return ed.viewEventsForMember(MID);
		}
		
		public Event viewSpecificEvent(int EID) {
			return ed.viewSpecificEvent(EID);
		}
		
		public void addNewEvent(Event event) {
			ed.addNewEvent(event);
		}
		public void removeEvent(Event event) {
			ed.removeEvent(event);
}
		
}