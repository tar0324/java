package com.myspring.pro30.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro30.board.vo.ArticleVO;
import com.myspring.pro30.board.vo.ImageVO;



@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ArticleVO> selectAllArticlesList() throws Exception {
		List<ArticleVO> articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
		return articlesList;
	}
	
	
	@Override
	public int insertNewArticle(Map articleMap) throws Exception {
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mapper.board.insertNewArticle", articleMap);
		return articleNO;
	}
	
	@Override
	public void insertNewImage(Map articleMap) throws DataAccessException {
		List<ImageVO> imageFileList = (ArrayList)articleMap.get("imageFileList");
		int articleNO = (Integer)articleMap.get("articleNO");
		int imageFileNO = selectNewImageFileNO();
		for(ImageVO imageVO : imageFileList) {
			imageVO.setImageFileNO(++imageFileNO);
			imageVO.setArticleNO(articleNO);
		}
		sqlSession.insert("mapper.board.insertNewImage", imageFileList);
	}
	


	@Override
	public ArticleVO selectArticle(int articleNO) throws Exception {
		ArticleVO articleVO = sqlSession.selectOne("mapper.board.selectArticle",articleNO);
		return articleVO;
	}
	 
	@Override
	public int updateArticle(Map articleMap) throws DataAccessException {
		int result = sqlSession.update("mapper.board.updateArticle", articleMap);
		return result;
	}
	
	@Override
	public int deleteArticle(int articleNO) throws DataAccessException {
		int result = sqlSession.delete("mapper.board.deleteArticle", articleNO);
		return result;
	}
	
	
	
	@Override
	public List selectImageFileList(int articleNO) throws DataAccessException {
		List<ImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.board.selectImageFileList", articleNO);
		return imageFileList;
	}
	 
	 @Override
	 public int replyArticle(Map articleMap) throws Exception {
		 int articleNO = selectNewArticleNO();
		 articleMap.put("articleNO", articleNO);
		 sqlSession.insert("mapper.board.insertreplyArticle", articleMap);
		 return articleNO;
	 }
	
	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleNO");
	}
	
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewImageFileNO");
	}

	/*
	 * @Override public void modArticle(Map articleMap) throws Exception {
	 * List<ArticleVO> articlesList =
	 * sqlSession.selectList("mapper.board.selectAllArticlesList"); return
	 * articlesList; }
	 */

	/*
	 * @Override public void removeArticle(int articleNO) throws Exception {
	 * List<ArticleVO> articlesList =
	 * sqlSession.selectList("mapper.board.selectAllArticlesList"); return
	 * articlesList; }
	 */
}
