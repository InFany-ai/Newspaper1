namespace Newspaper.Models;

public class Grade
{
    public Guid GradeId { get; set; }
    public Guid ArticleId { get; set; }
    public Guid AuthorId { get; set; }
    public int Value { get; set; }
}