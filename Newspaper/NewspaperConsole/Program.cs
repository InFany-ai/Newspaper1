
using NewspaperConsole.Models;
using NewspaperConsole.Utils;

var path = "C:\\Users\\gogii\\Desktop\\4 курс 1 семестр\\ИТРОИ\\NewspaperGit\\Newspaper\\NewspaperConsole\\xml\\";

XmlGenerator.GenerateXml(EntityGenerator.GetConstArticle(), path);
XslGenerator.GenerateXslSchema(typeof(Article), path);
HtmlGenerator.GenerateHtml(path, typeof(Article));
