<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
<html>
<head>
<h1>Article</h1>
<title>Article Details</title>
<style>
                    body {
                    font-family: Arial, sans-serif;
                    line-height: 1.6;
                    margin: 20px;
                    }
                    h1 {
                    color: #333;
                    }
                    .section {
                    margin-bottom: 20px;
                    }
                    .temp-c {
                    border: 1px solid #ccc;
                    padding: 10px;
                    margin-bottom: 10px;
                    margin-inline: 10px;
                    }
                    
                    .section-flex {
                    display: flex;
                    }
                </style>
</head>
<body>
<div class="section">
<xsl:apply-templates select="Article" />
</div>
<div class="section">
<h2>Author</h2>
<xsl:apply-templates select="Article/Author" />
</div>

<div class="section">
<h2>Comments</h2>
<div class="section-flex">
<xsl:apply-templates select="Article/Comments/Comment" />
</div>
</div>
<div class="section">
<h2>Grades</h2>
<div class="section-flex">
<xsl:apply-templates select="Article/Grades/Grade" />
</div>
</div>

</body>
</html>
</xsl:template>
<xsl:template match="Article">
<div class="temp-c">
<p><strong>Title: </strong> <xsl:value-of select="Title"/></p>
<p><strong>Body: </strong> <xsl:value-of select="Body"/></p>
<p><strong>Id: </strong> <xsl:value-of select="Id"/></p>

</div>
</xsl:template>
<xsl:template match="Comment">
<div class="temp-c">
<p><strong>Body: </strong> <xsl:value-of select="Body"/></p>
<p><strong>ArticleId: </strong> <xsl:value-of select="ArticleId"/></p>
<p><strong>Id: </strong> <xsl:value-of select="Id"/></p>

</div>
</xsl:template>
<xsl:template match="Grade">
<div class="temp-c">
<p><strong>ArticleId: </strong> <xsl:value-of select="ArticleId"/></p>
<p><strong>AuthorId: </strong> <xsl:value-of select="AuthorId"/></p>
<p><strong>Value: </strong> <xsl:value-of select="Value"/></p>
<p><strong>Id: </strong> <xsl:value-of select="Id"/></p>

</div>
</xsl:template>
<xsl:template match="Author">
<div class="temp-c">
<p><strong>FirstName: </strong> <xsl:value-of select="FirstName"/></p>
<p><strong>LastName: </strong> <xsl:value-of select="LastName"/></p>
<p><strong>Age: </strong> <xsl:value-of select="Age"/></p>
<p><strong>Id: </strong> <xsl:value-of select="Id"/></p>

</div>
</xsl:template>

</xsl:stylesheet>
