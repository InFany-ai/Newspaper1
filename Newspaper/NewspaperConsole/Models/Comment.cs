namespace NewspaperConsole.Models;

public class Comment
{
    public int CommentId { get; set; }
    public string Body { get; set; } = null!;
    public int ArticleId { get; set; }
}