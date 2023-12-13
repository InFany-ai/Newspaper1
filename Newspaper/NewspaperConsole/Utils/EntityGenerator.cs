using NewspaperConsole.Models;

namespace NewspaperConsole.Utils;

public static class EntityGenerator
{
    public static Article GetConstArticle()
    {
        var article = new Article
        {
            Id = 1,
            Title = "Article Title",
            Body = "Article Body",
            Author = new Author()
            {
                Id = 1,
                FirstName = "Author FirstName",
                LastName = "Author LastName",
                Age = 20,
            },
            Comments = new List<Comment>
            {
                new Comment
                {
                    Id = 1,
                    Body = "Comment Body1",
                    ArticleId = 1
                },
                new Comment
                {
                    Id = 2,
                    Body = "Comment Body1",
                    ArticleId = 1
                }
            },
            Grades = new List<Grade>
            {
                new Grade
                {
                    Id = 1,
                    ArticleId = 1,
                    AuthorId = 1,
                    Value = 5
                },
                new Grade
                {
                    Id = 2,
                    ArticleId = 1,
                    AuthorId = 1,
                    Value = 4
                }
            }
        };
        return article;
    }

    public static Grade GetConstGrade()
    {
        return new Grade()
        {
            Id = 1,
            Value = 5,
            ArticleId = 1,
            AuthorId = 1
        };
    }
}