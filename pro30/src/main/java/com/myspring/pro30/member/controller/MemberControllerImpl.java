package com.myspring.pro30.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro30.member.service.MemberService;
import com.myspring.pro30.member.vo.MemberVO;






@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO;
	
	@RequestMapping(value = {"/","/main.do"}, method = RequestMethod.GET)
	private ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("viewName:::::" + viewName);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("viewName:::::" + viewName);
		logger.info("info 레벨 : viewName: " + viewName);
	    logger.debug("debug 레벨 : viewName: " + viewName);     
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	
	@Override
	@RequestMapping(value="/member/viewMember.do", method = RequestMethod.GET)
	public ModelAndView viewMember(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String viewName = getViewName(request);
		
		memberVO = memberService.viewMember(id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", memberVO);
		return mav;

	}

	
	@Override
	@RequestMapping(value="/member/modMember.do", method = RequestMethod.POST)
	public ModelAndView modMember(@ModelAttribute("member") MemberVO member,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int result = 0;
		result = memberService.modMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;

	}
	
	@Override
	@RequestMapping(value="/member/searchMember.do", method = RequestMethod.GET)
	public ModelAndView searchMember(@RequestParam("action") String action, @RequestParam("value") String value, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = "/member/listMembers";
		ModelAndView mav = new ModelAndView(viewName);
		
		if(action == null || action.equals("selectlistMembers")) {
			List membersList = memberService.selectlistMembers(value);
			mav.addObject("membersList", membersList);
			
		} else if (action.equals("selectMemberById")) {
			List membersList = memberService.selectMemberById(value);
			mav.addObject("membersList", membersList);
			
		} else if (action.equals("selectMemberByPwd")) {
			List membersList = memberService.selectMemberByPwd(value);
			mav.addObject("membersList", membersList);
		}
		
		return mav;

	}
	
	@RequestMapping(value = { "/member/loginForm.do", "/member/memberForm.do" }, method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}

	
	
	 @Override
	   @RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	   public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
	      ModelAndView mav = new ModelAndView();
//	      System.out.println("member:::::::::"+member);
	      memberVO = memberService.login(member);
	      if (memberVO != null) {
	         HttpSession session = request.getSession();
	         session.setAttribute("member", memberVO);
	         session.setAttribute("isLogOn", true);
	         
	         String action = (String)session.getAttribute("action");
	         session.removeAttribute("action");
	         if(action != null) {
	        	 mav.setViewName("redirect: " + action);
	         } else {
	        	 mav.setViewName("redirect:/member/listMembers.do");
	         }
	         
	      } else {
	    	 rAttr.addFlashAttribute("result", "loginFailed");
	         mav.setViewName("redirect:/member/loginForm.do");
	      }
	      return mav;
	   }

	
	/*
	 * @Override
	 * 
	 * @RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	 * public ModelAndView login(@ModelAttribute("member") MemberVO member,
	 * RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse
	 * response) throws Exception { ModelAndView mav = new ModelAndView(); memberVO
	 * = memberService.login(member); if (memberVO != null) { HttpSession session =
	 * request.getSession(); session.setAttribute("member", memberVO);
	 * session.setAttribute("isLogOn", true);
	 * mav.setViewName("redirect:/member/listMembers.do"); } else {
	 * rAttr.addFlashAttribute("result", "loginFailed");
	 * mav.setViewName("redirect:/member/loginForm.do");
	 * 
	 * } return mav; }
	 */
	
	@Override
	@RequestMapping(value = "/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");

		return mav;
	}

	
	@RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value="result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!((contextPath==null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end=uri.length();
		}
		
		String fileName = uri.substring(begin,end);
		if(fileName.indexOf(".") != -1) {
			fileName=fileName.substring(0,fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/",1), fileName.length());
		}
		return fileName;
	}
}
