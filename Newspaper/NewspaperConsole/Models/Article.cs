namespace NewspaperConsole.Models;

public class Article : EntityWithId
{
    public string Title { get; set; } = null!;
    public string Body { get; set; } = null!;
    public List<Comment> Comments { get; set; } = null!;
    public List<Grade> Grades { get; set; } = null!;
    public Author Author { get; set; } = null!;
}