package com.myspring.pro30.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.member.vo.MemberVO;


public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;

	public MemberVO viewMember(String id) throws DataAccessException;

	public int modMember(MemberVO memberVO) throws DataAccessException; 
	
	public List selectlistMembers(String value) throws DataAccessException;
	public List selectMemberById(String value) throws DataAccessException;
	public List selectMemberByPwd(String value) throws DataAccessException;
	
	
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;
}
