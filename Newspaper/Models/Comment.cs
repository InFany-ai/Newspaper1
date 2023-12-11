namespace Newspaper.Models;

public class Comment
{
    public Guid CommentId { get; set; }
    public string Body { get; set; } = null!;
    public Guid ArticleId { get; set; }
}