package sprint.boot.testing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sprint.boot.testing.model.Article;

/**
 *
 * @author Traly created date: Oct 2, 2020
 *
 */

@Mapper
public interface ArticleMapper {
	@Select("SELECT * FROM article WHERE id = #{id}")
	List<Article> findById(@Param("id") long id);

	@Select("SELECT * FROM article")
	List<Article> findAll();

	@Insert("INSERT INTO article(title, author) VALUES( #{title} , #{author} )")
	String add(String title, String author);
}
