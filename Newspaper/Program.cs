using System.Text;
using System.Xml;
using System.Xml.Schema;
using System.Xml.Serialization;
using Newspaper.Models;
using Newspaper.Utils;

//copilot change encoding to utf-8


XmlReflectionImporter importer = new XmlReflectionImporter();
XmlTypeMapping mapping = importer.ImportTypeMapping(typeof(Article));

XmlSchemas schemas = new XmlSchemas();
XmlSchemaExporter exporter = new XmlSchemaExporter(schemas);

exporter.ExportTypeMapping(mapping);

foreach (XmlSchema schema in schemas)
{
    // Save the generated schema to a file with UTF-8 encoding
    SaveSchemaToFile(schema, "xml\\Article.xsd");
}


var serializer = new XmlSerializer(typeof(Article));
TextWriter writerT = new StreamWriter("xml\\Article.xml");
serializer.Serialize(writerT, ArticleGenerator.GetConstArticle());

try
{
    XmlReaderSettings settings = new XmlReaderSettings();
    settings.Schemas.Add("", "xml\\Article.xsd");
    settings.ValidationType = ValidationType.Schema;

    XmlReader reader = XmlReader.Create("xml\\Article.xml", settings);
    XmlDocument document = new XmlDocument();
    document.Load(reader);


    document.Validate(null);
}
catch (Exception e)
{
    Console.WriteLine(e.Message);
}



///////////////////////////////////////////////////////////////
void SaveSchemaToFile(XmlSchema schema, string filePath)
{
    XmlWriterSettings settings = new XmlWriterSettings
    {
        Indent = true,
        Encoding = new UTF8Encoding(false) // Use UTF-8 without BOM
    };

    using (XmlWriter writer = XmlWriter.Create(filePath, settings))
    {
        schema.Write(writer);
    }

    Console.WriteLine($"Schema saved to {filePath}");
}