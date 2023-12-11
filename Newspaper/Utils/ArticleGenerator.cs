using Newspaper.Models;

namespace Newspaper.Utils;

public static class ArticleGenerator
{
    public static Article GetConstArticle()
    {
        var article = new Article
        {
            ArticleId = Guid.NewGuid(),
            Title = "Article Title",
            Body = "Article Body",
            AuthorId = Guid.NewGuid(),
            Comments = new List<Comment>
            {
                new Comment
                {
                    CommentId = Guid.NewGuid(),
                    Body = "Comment Body1",
                    ArticleId = Guid.NewGuid()
                },
                new Comment
                {
                    CommentId = Guid.NewGuid(),
                    Body = "Comment Body1",
                    ArticleId = Guid.NewGuid()
                }
            },
            Grades = new List<Grade>
            {
                new Grade
                {
                    GradeId = Guid.NewGuid(),
                    ArticleId = Guid.NewGuid(),
                    AuthorId = Guid.NewGuid(),
                    Value = 5
                },
                new Grade
                {
                    GradeId = Guid.NewGuid(),
                    ArticleId = Guid.NewGuid(),
                    AuthorId = Guid.NewGuid(),
                    Value = 4
                }
            }
        };
        return article;
    }
}