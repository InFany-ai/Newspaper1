package ua.nure.parser;

public interface Const {

	String TAG_ARTICLE = "Article";
	String TAG_ARTICLES = "Articles";
	String TAG_ARTICLETAG = "ArticleTag";
	String ATTRIBUTE_ID = "Id";
	String TAG_NAME = "Name";
	String TAG_ARTICLEID = "ArticleId";
	String TAG_FIRSTNAME = "FirstName";
	String TAG_LASTNAME = "LastName";
	String TAG_AGE = "Age";
	String TAG_BODY = "Body";
	String TAG_TITLE = "Title";
	String ARTICLES_NAMESPACE_URI = "http://article.nure.ua/entity/article/";
	String TAG_AUTHOR = "Author";
	String TAG_GRADE = "Grade";
	String TAG_COMMENT = "Comment";
	String TAG_VALUE = "Value";


	String XML_FILE = "xml/Articles.xml";
	String INVALID_XML_FILE = "xml/invalid_articles.xml";
	String XSD_FILE = "xml/Articles.xsd";
	Class<?> OBJECT_FACTORY = ua.nure.article.entity.article.ObjectFactory.class;
	
	String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
	String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
	String XSI_SPACE__PREFIX = "xsi";
	String SCHEMA_LOCATION__URI = "http://article.nure.ua/entity/article/ Articles.xsd";

	// validation features
	public static final String FEATURE__TURN_VALIDATION_ON = 
			"http://xml.org/sax/features/validation";
	public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON = 
			"http://apache.org/xml/features/validation/schema";

}
