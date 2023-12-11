using NewspaperConsole.Models;

namespace NewspaperConsole.Utils;

public static class ArticleGenerator
{
    public static Article GetConstArticle()
    {
        var article = new Article
        {
            ArticleId = 1,
            Title = "Article Title",
            Body = "Article Body",
            AuthorId = 1,
            Comments = new List<Comment>
            {
                new Comment
                {
                    CommentId = 1,
                    Body = "Comment Body1",
                    ArticleId = 1
                },
                new Comment
                {
                    CommentId = 2,
                    Body = "Comment Body1",
                    ArticleId = 1
                }
            },
            Grades = new List<Grade>
            {
                new Grade
                {
                    GradeId = 1,
                    ArticleId = 1,
                    AuthorId = 1,
                    Value = 5
                },
                new Grade
                {
                    GradeId = 2,
                    ArticleId = 1,
                    AuthorId = 1,
                    Value = 4
                }
            }
        };
        return article;
    }
}