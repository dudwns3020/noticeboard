package com.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public List<Article> getArticles();

	public Article getArticle(int id);

	public int writeArticle(String title, String body);

	public void deleteArticle(int id);

	public void modifyArticle(int id, String title, String body);

	public int getLastInsertId();

}