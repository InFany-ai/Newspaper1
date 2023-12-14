using NewspaperConsole.Models.Base;

namespace NewspaperConsole.Models;

public class ArticleTag : EntityWithId
{
    public string Name { get; set; } = null!;
    public int ArticleId { get; set; }
}