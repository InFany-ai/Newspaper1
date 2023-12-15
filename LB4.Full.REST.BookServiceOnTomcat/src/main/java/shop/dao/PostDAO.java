package shop.dao;

import shop.entity.Post;
import shop.entity.Posts;

public interface PostDAO {
	public int addPost(Post item) throws DAOException;
	public Post deletePost(int id) throws DAOException;
	public Posts findByTitleAndAuthor(String pattern, String author);
	public Posts newPosts();
	public Post findById(Integer id) throws DAOException;
	int editPost(int id, Post post) throws DAOException;
}
