package sprint.boot.testing.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@RequestMapping("/articles/add")
	public void addArticle(@RequestBody Map<String, String> article) {
		articleMapper.add(article.get("title"), article.get("author"));
	}

	@PutMapping("/articles/update/{id}")
	public void updateArticle(@PathVariable("id") long id, @RequestBody Map<String, String> article) {
		articleMapper.update(id, article.get("title"), article.get("author"));
	}

	@DeleteMapping("/articles/delete/{id}")
	public void deleteArticle(@PathVariable("id") long id) {
		articleMapper.delete(id);
	}
}
