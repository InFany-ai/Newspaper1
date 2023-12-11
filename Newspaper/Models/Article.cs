namespace Newspaper.Models;

public class Article
{
    public Guid ArticleId { get; set; }
    public string Title { get; set; } = null!;
    public string Body { get; set; } = null!;
    public Guid AuthorId { get; set; }
    public List<Comment> Comments { get; set; } = null!;
    public List<Grade> Grades { get; set; } = null!;
}