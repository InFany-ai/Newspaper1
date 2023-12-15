package shop.dao;

import shop.additions.SearchParams;
import shop.dao.dbtable.DBTable;
import shop.dao.dbtable.DBTableFactory;
import shop.dao.dbtable.Filter;
import shop.entity.*;

import java.sql.SQLException;
import java.util.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class PostDAOInMemoryImpl implements PostDAO {

	DBTable<Post> Posts = DBTableFactory.instance();
	
	private static PostDAOInMemoryImpl instance;

	private PostDAOInMemoryImpl() {
		try {
			initPosts();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static synchronized PostDAOInMemoryImpl instance() {
		if (instance == null) {
			instance = new PostDAOInMemoryImpl();
		}
		return instance;
	}
	
	@Override
	public synchronized int addPost(Post item) {
		int id = Posts.insert(item);
		item.setId(id);
		try {
			Posts.update(id, item);
		} catch (SQLException e) {
			try {
			Posts.delete(id);
			} catch (SQLException e1) {
				// Do nothing
			}
		}
		return id;
	}

	@Override
	public synchronized Post deletePost(int id) throws DAOException {
		try {
			return Posts.delete(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	Filter<Post> headerFilter = new Filter<>() {
		@Override
		public boolean accept(Post item, Object searchParams) {
			SearchParams params = (SearchParams) searchParams;
			if (item.getHeader() != null && params.getPattern() != null && !item.getHeader().toUpperCase().contains(params.getPattern().toUpperCase())) {
				return false;
			}
			if (item.getCreatedBy() != null && item.getCreatedBy().getUsername() != null && params.getAuthor() != null && !item.getCreatedBy().getUsername().toUpperCase().contains(params.getAuthor().toUpperCase())) {
				return false;
			}
			return true;
		}
	};
	
	Filter<Post> authorFilter = new Filter<>() {
		@Override
		public boolean accept(Post item, Object pattern) {
			String p = (String) pattern;
			Author author = item.getCreatedBy();
            return author.getUsername().toUpperCase().contains(p.toUpperCase());
        }
	};

	Comparator<Post> byDate = new Comparator<Post>() {
		@Override
		public int compare(Post o1, Post o2) {
			var date1 = o1.getDate();
			var date2 = o2.getDate();
			if (date1 == null || date2 == null) return 0;
			return o1.getDate().compare(o2.getDate());
		}
	};
	
	@Override
	public Posts findByTitleAndAuthor(String pattern, String author) {
		var posts = Posts.filter(new SearchParams(pattern, author), headerFilter);
		Posts result = new Posts();
		result.getPost().addAll(posts);
		return result;
	}

	@Override
	public Posts newPosts() {
		var posts = new ArrayList<>(Posts.selectAll());
		posts.sort(byDate);
		Posts result = new Posts();
		result.getPost().addAll(posts);
		return result;
	}

	@Override
	public Post findById(Integer id) throws DAOException {
		try {
			return Posts.get(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int editPost(int id, Post post) throws DAOException {
		try {
			var oldPost = findById(id);
			Posts.update(id, post);
			return post.getId();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	private Post newPost(String header, String text, Images images, Author author, AccessLevel accessLevel) throws DatatypeConfigurationException {
		Post post = new Post();
		post.setHeader(header);
		post.setText(text);
		post.setImages(images);
		post.setCreatedBy(author);
		post.setAccessLevel(accessLevel);
		post.setLikes(0);
		var date = new GregorianCalendar();
		XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
		post.setDate(xmlGregCal);
		return post;
	}

	private void initPosts() throws DatatypeConfigurationException {
		Post[] posts = new Post[] {
				newPost("Тест 111", "Что-то про тест и все такое", new Images(), null, AccessLevel.PUBLIC)
//				newPost("Божественная комедия",
//						Arrays.asList(new String[] {"Данте Алигьери"}),
//						"ISBN-01234-0123", 125.0, Category.LOVE_NOVEL, 3),
//				newPost("Сказки",
//						Arrays.asList(new String[] {"Ханс Кристиан Андерсен"}),
//						"ISBN-01234-0124", 300.0, Category.ACTION, 12),
//				newPost("И пришло разрушение",
//						Arrays.asList(new String[] {"Чинуа Ачебе"}),
//						"ISBN-01234-0125", 245.5, Category.ACTION, 4),
//				newPost("Отец Горио",
//						Arrays.asList(new String[] {"Оноре де Бальзак"}),
//						"ISBN-01234-0126", 245.5, Category.LOVE_NOVEL, 5),
//				newPost("Вымыслы",
//						Arrays.asList(new String[] {"Хорхе Луис Борхес"}),
//						"ISBN-01234-0127", 118.3, Category.FANTASY, 8),
//				newPost("Декамерон",
//						Arrays.asList(new String[] {"Джованни Боккаччо"}),
//						"ISBN-01234-0128", 148.7, Category.LOVE_NOVEL, 7),
				};
		for (int i = 0; i < posts.length; i++) {
			addPost(posts[i]);
		}
	}
}
