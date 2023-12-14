using NewspaperConsole.Models.Base;

namespace NewspaperConsole.Models;

public class Grade : EntityWithId
{
    public int ArticleId { get; set; }
    public int Value { get; set; }
}