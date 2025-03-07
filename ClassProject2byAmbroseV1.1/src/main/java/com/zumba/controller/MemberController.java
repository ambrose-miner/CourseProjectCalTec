package com.zumba.controller;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zumba.bean.MemberEvent;
import com.zumba.bean.Member;
import com.zumba.bean.Event;
import com.zumba.service.MemberService;
import com.zumba.service.EventService;
import com.zumba.service.MemberEventService;

@WebServlet("/memberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberController() {
        super();
    }
    
	
		private MemberService ms = new MemberService();
		private EventService es = new EventService();
		private MemberEventService mes = new MemberEventService();
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Member> listOfMember = ms.viewAllMemberDetails();
			HttpSession hs = request.getSession();
			hs.setAttribute("listAllMember", listOfMember);
			response.sendRedirect("viewAllMember.jsp");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			 
	}
		
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userAction = request.getParameter("userAction");
			if (userAction .equals("viewSpecificMember")) {
				
			int memberID = Integer.parseInt(request.getParameter("MID"));
			Member im = ms.viewSpecificMember(memberID);
			HttpSession hs = request.getSession();
			hs.setAttribute("specificMember", im);
			List<Event> listOfEventForMember = es.viewEventsForMember(memberID);
			hs.setAttribute("listOfEvent", listOfEventForMember);
			response.sendRedirect("viewSpecificMember.jsp");
			
			}else if  (userAction .equals("addMember")) {
				
			
				String memberF_name = request.getParameter("f_name");
				String memberL_name = request.getParameter("l_name");
				String memberEmail = request.getParameter("email");
				
				Member nm = new Member();
				nm.setF_name(memberF_name);
				nm.setL_name(memberL_name);
				nm.setEmail(memberEmail);
				ms.addNewMember(nm);
				
				
			}else if (userAction .equals("deleteMember")) {
				Member rm = new Member();
				int memberID = Integer.parseInt(request.getParameter("MID"));
				HttpSession hs = request.getSession();	// same as comment below right?
				rm.setMID(memberID);
				ms.removeMember(rm);
			
		
			doGet(request, response); // after removing a member takes user back to list of members
			}
			else if (userAction .equals("removeMemberFromEvent")) {
				MemberEvent rmfe = new MemberEvent();
				int memberID = Integer.parseInt(request.getParameter("MID"));
				int eventID = Integer.parseInt(request.getParameter("EID"));
				HttpSession hs = request.getSession(); // Do I need this line? I am getting the value of the strings from the request above
				// but I am deleting and I don't use hs so I'm not putting anything in the session. Right? Same for Delete member above.
				rmfe.setMID(memberID);
				rmfe.setEID(eventID);
				mes.removeMemberFromEvent(rmfe);
				response.sendRedirect("viewSpecificEvent.jsp");//I need a conditional redirect response if I am going to have this in two places.
				//If they are viewing the member and remove them from event vs if your on an event and remove a member and return them to viewing the event.
			}
		}
}
