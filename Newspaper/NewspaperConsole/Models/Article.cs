namespace NewspaperConsole.Models;

public class Article
{
    public int ArticleId { get; set; }
    public string Title { get; set; } = null!;
    public string Body { get; set; } = null!;
    public int AuthorId { get; set; }
    public List<Comment> Comments { get; set; } = null!;
    public List<Grade> Grades { get; set; } = null!;
}