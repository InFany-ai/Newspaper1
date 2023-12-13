namespace NewspaperConsole.Models;

public class Grade : EntityWithId
{
    public int ArticleId { get; set; }
    public int AuthorId { get; set; }
    public int Value { get; set; }
}