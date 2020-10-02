package sprint.boot.testing.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sprint.boot.testing.dao.ArticleMapper;
import sprint.boot.testing.model.Article;

/**
 * @author Traly created date: Oct 2, 2020
 */

@RestController
public class ArticleController {
	@Autowired
	private ArticleMapper articleMapper;

	@RequestMapping("/")
	public List<Article> home() {
		return (articleMapper.findAll());
	}

	@RequestMapping("/articles")
	public List<Article> article() {
		return home();
	}

	@RequestMapping("/articles/{id}")
	public List<Article> articleById(@PathVariable("id") long id) {
		return articleMapper.findById(id);
	}

	@PostMapping("/articles/add")
	public Map<String, String> addArticle(@RequestBody Map<String, String> article) {
		articleMapper.add(article.get("title"), article.get("author"));
		return article;
	}
}
