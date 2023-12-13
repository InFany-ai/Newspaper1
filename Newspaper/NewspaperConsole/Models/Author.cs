namespace NewspaperConsole.Models;

public class Author : EntityWithId
{
    public string FirstName { get; set; } = null!;
    public string? LastName { get; set; }
    public int Age { get; set; }
}