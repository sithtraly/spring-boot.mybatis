package sprint.boot.testing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Map<String, String> addArticle(@RequestBody Map<String, String> article) {
		try {
			articleMapper.add(article.get("title"), article.get("author"));
			article.put("status", "created");
			return article;
		} catch (Exception e) {
			article.put("status", "create fail");
			return article;
		}
	}

	@PutMapping("/articles/update/{id}")
	public Map<String, String> updateArticle(@PathVariable("id") long id, @RequestBody Map<String, String> article) {
		try {
			articleMapper.update(id, article.get("title"), article.get("author"));
			article.put("status", "updated");
			return article;
		} catch (Exception e) {
			article.put("status", "update fail");
			return article;
		}

	}

	@DeleteMapping("/articles/delete/{id}")
	public Map<String, String> deleteArticle(@PathVariable("id") long id) {
		Map<String, String> json = new HashMap<String, String>();
		try {
			articleMapper.delete(id);
			json.put("status", "deleted");
			return json;
		} catch (Exception e) {
			json.put("status", "delete fail");
			return json;
		}

	}
}
