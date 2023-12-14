using System.Text;
using System.Xml;
using System.Xml.Schema;
using System.Xml.Serialization;

namespace NewspaperConsole.Utils;

public static class XsdGenerator
{
    public static void GenerateXsd(string path, Type type)
    {
        var schemas = new XmlSchemas();
        var exporter = new XmlSchemaExporter(schemas);
        var mapping = new XmlReflectionImporter().ImportTypeMapping(type);
        exporter.ExportTypeMapping(mapping);
        XmlWriterSettings settingsA = new XmlWriterSettings
        {
            Indent = true,
            Encoding = new UTF8Encoding(false)
        };

        foreach (XmlSchema schema in schemas)
        {
            using (XmlWriter writer = XmlWriter.Create($"{path}{type.Name}.xsd", settingsA))
            {
                schema.Write(writer);;
            }
        }
    }
}