namespace NewspaperConsole.Models;

public class Comment : EntityWithId
{
    public string Body { get; set; } = null!;
    public int ArticleId { get; set; }
}