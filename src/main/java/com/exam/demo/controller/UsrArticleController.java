package com.exam.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.demo.service.ArticleService;
import com.exam.demo.ut.Ut;
import com.exam.demo.vo.Article;

@Controller
public class UsrArticleController {

	private ArticleService articleService;

	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		List<Article> articles = articleService.getArticles();

		model.addAttribute("articles", articles);

		return "usr/article/list";
	}

	@RequestMapping("/usr/article/detail")
	public String showDetail(Model model, int id) {
		Article article = articleService.getarticle(id);

		model.addAttribute("article", article);

		return "usr/article/detail";
	}

	@RequestMapping("usr/article/doWrite")
	@ResponseBody
	public String doWrite(String title, String body) {
		int id = articleService.writeArticle(title, body);

		Article article = articleService.getarticle(id);

		return Ut.jsReplace(Ut.f("%d번 게시물이 생성되었습니다.", id), "/usr/article/list");
	}

	@RequestMapping("usr/article/write")
	public String showWrite(String title, String body) {

		return "usr/article/write";
	}

	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getarticle(id);

		articleService.deleteArticle(id);

		if (article == null) {
			return Ut.jsReplace("게시물이 존재하지 않습니다.", "/usr/article/list");
		}

		return Ut.jsReplace(Ut.f("%d번 게시물이 삭제되었습니다.", id), "/usr/article/list");
	}

	@RequestMapping("usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getarticle(id);

		articleService.modifyArticle(id, title, body);

		if (Ut.empty(title) && Ut.empty(body)) {
			return Ut.jsHistoryBack("제목과 내용을 입력해주세요.");
		}

		if (Ut.empty(title)) {
			return Ut.jsHistoryBack("제목을 입력해주세요.");
		}

		if (Ut.empty(body)) {
			return Ut.jsHistoryBack("내용을 입력해주세요.");
		}

		return Ut.jsReplace(Ut.f("%d번 게시물이 수정되었습니다.", id), "/usr/article/list");
	}

	@RequestMapping("usr/article/modify")
	public String showmodify(Model model, int id) {
		Article article = articleService.getarticle(id);

		model.addAttribute("article", article);

		return "usr/article/modify";
	}

}