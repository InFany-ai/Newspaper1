using System.Runtime.CompilerServices;
using NewspaperConsole.Models;
using NewspaperConsole.Models.Base;
using NewspaperConsole.Utils;

var path = "D:\\4_1\\ITROI\\NewspaperGit\\Newspaper\\NewspaperConsole\\xml";

XmlGenerator.GenerateXml(EntityGenerator.GetListArticles(3), path);
