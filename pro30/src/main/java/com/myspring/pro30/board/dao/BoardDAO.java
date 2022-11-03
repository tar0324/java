package com.myspring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.board.vo.ArticleVO;



public interface BoardDAO {
	public List<ArticleVO> selectAllArticlesList() throws Exception;
	public int insertNewArticle(Map articleMap) throws Exception;
	public ArticleVO selectArticle(int articleNO) throws Exception;
	public int updateArticle(Map articleMap) throws DataAccessException;
	public int deleteArticle(int articleNO) throws DataAccessException;
	public void insertNewImage(Map articleMap) throws DataAccessException;
	//private int selectNewImageFileNO() throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;
	public int replyArticle(Map articleMap) throws Exception;


}
