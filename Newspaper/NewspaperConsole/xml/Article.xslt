<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <h1>Newspaper</h1>
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
                    .comment, .grade {
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
                    <h1><xsl:value-of select="Article/Title"/></h1>
                    <p><strong>Article ID:</strong> <xsl:value-of select="Article/ArticleId"/></p>
                    <p><strong>Body:</strong> <xsl:value-of select="Article/Body"/></p>
                    <p><strong>Author ID:</strong> <xsl:value-of select="Article/AuthorId"/></p>
                </div>

                <div class="section">
                    <h2>Comments:</h2>
                    <div class="section-flex">
                        <xsl:apply-templates select="Article/Comments/Comment"/>
                    </div>>
                </div>

                <div class="section">
                    <h2>Grades:</h2>
                    <div class="section-flex">
                        <xsl:apply-templates select="Article/Grades/Grade"/>
                    </div>>
                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Comment">
        <div class="comment">
            <p><strong>Comment ID:</strong> <xsl:value-of select="CommentId"/></p>
            <p><strong>Comment Body:</strong> <xsl:value-of select="Body"/></p>
            <p><strong>Article ID:</strong> <xsl:value-of select="ArticleId"/></p>
        </div>
    </xsl:template>

    <xsl:template match="Grade">
        <div class="grade">
            <p><strong>Grade ID:</strong> <xsl:value-of select="GradeId"/></p>
            <p><strong>Article ID:</strong> <xsl:value-of select="ArticleId"/></p>
            <p><strong>Author ID:</strong> <xsl:value-of select="AuthorId"/></p>
            <p><strong>Value:</strong> <xsl:value-of select="Value"/></p>
        </div>
    </xsl:template>

</xsl:stylesheet>
