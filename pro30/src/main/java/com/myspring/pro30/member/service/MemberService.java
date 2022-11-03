package com.myspring.pro30.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.member.vo.MemberVO;





public interface MemberService {
	public List listMembers() throws DataAccessException;
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	
	public MemberVO viewMember(String id) throws DataAccessException;

	public int modMember(MemberVO memberVO) throws DataAccessException; 
	
	public List selectlistMembers(String value) throws DataAccessException;
	public List selectMemberById(String value) throws DataAccessException;
	public List selectMemberByPwd(String value) throws DataAccessException;
	
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception; 
}
