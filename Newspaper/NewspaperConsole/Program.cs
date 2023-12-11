using System.Text;
using System.Xml;
using System.Xml.Schema;
using System.Xml.Serialization;
using System.Xml.Xsl;
using NewspaperConsole.Models;
using NewspaperConsole.Utils;

var path = "C:\\Users\\gogii\\Desktop\\4 курс 1 семестр\\ИТРОИ\\Newspaper\\NewspaperConsole\\xml\\";
var schemas = new XmlSchemas();
var exporter = new XmlSchemaExporter(schemas);
var mapping = new XmlReflectionImporter().ImportTypeMapping(typeof(Article));
exporter.ExportTypeMapping(mapping);
XmlWriterSettings settingsA = new XmlWriterSettings
{
    Indent = true,
    Encoding = new UTF8Encoding(false)
};

using (XmlWriter writer = XmlWriter.Create($"{path}Article.xsd", settingsA))
{
    schemas.First().Write(writer);
}


var serializer = new XmlSerializer(typeof(Article));
using TextWriter writerT = new StreamWriter($"{path}Article.xml");
serializer.Serialize(writerT, ArticleGenerator.GetConstArticle());
writerT.Dispose();
try
{
    XmlReaderSettings settings = new XmlReaderSettings();
    settings.Schemas.Add("", $"{path}Article.xsd");
    settings.ValidationType = ValidationType.Schema;

    using XmlReader reader = XmlReader.Create($"{path}Article.xml", settings);
    XmlDocument document = new XmlDocument();
    document.Load(reader);


    document.Validate(null);
    Console.WriteLine("Document is valid");
    
    reader.Dispose();
}
catch (Exception e)
{
    Console.WriteLine(e.Message);
}


XslCompiledTransform xslt = new XslCompiledTransform();

xslt.Load($"{path}Article.xslt");
xslt.Transform($"{path}Article.xml", $"{path}Article.html");