<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<html>
<body>
<table border="1">
<tr bgcolor="#9acd32">
<th>ArticleId</th>
<th>AuthorId</th>
<th>Value</th>
<th>Id</th>
</tr>
<xsl:for-each select="root">
<tr>
<td><xsl:value-of select="ArticleId"/></td>
<td><xsl:value-of select="AuthorId"/></td>
<td><xsl:value-of select="Value"/></td>
<td><xsl:value-of select="Id"/></td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
