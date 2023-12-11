namespace Newspaper.Models;

public class Author
{
    public Guid AuthorId { get; set; }
    public string FirstName { get; set; } = null!;
    public string? LastName { get; set; }
    public int Age { get; set; }
}