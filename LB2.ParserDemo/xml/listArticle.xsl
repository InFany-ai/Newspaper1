<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:a="http://article.nure.ua/entity/article/">

	<xsl:template match="/">
		<html>
			<head>
				<title>Article Information</title>
				<style>
					.article-section {
					border: 1px solid #ccc;
					margin-bottom: 20px;
					padding: 10px;
					}
					.list-section {
					border: 1px solid #ddd;
					padding: 10px;
					margin-top: 10px;
					}
					.field-label {
					font-weight: bold;
					display: inline-block;
					width: 100px;
					margin: 0;
					}
					.field-value {
					display: inline-block;
					margin: 0;
					}
					.comment-box {
					border: 1px solid #ddd;
					padding: 10px;
					margin-top: 10px;
					}
				</style>
			</head>
			<body>
				<h1>Articles</h1>
				<xsl:apply-templates select="a:Articles/a:Article"/>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="a:Article">
		<div class="article-section">
			<h2>Article ID: <xsl:value-of select="@Id"/></h2>
			<p><span class="field-label">Title:</span><span class="field-value"><xsl:value-of select="a:Title"/></span></p>
			<p><span class="field-label">Body:</span><span class="field-value"><xsl:value-of select="a:Body"/></span></p>
			<h3>Author</h3>
			<xsl:apply-templates select="a:Author"/>
			<h3>Tags</h3>
			<div class="list-section">
				<xsl:apply-templates select="a:ArticleTag"/>
			</div>
			<h3>Comments</h3>
			<div class="list-section">
				<xsl:apply-templates select="a:Comment"/>
			</div>
			<h3>Grades</h3>
			<div class="list-section">
				<xsl:apply-templates select="a:Grade"/>
			</div>
		</div>
	</xsl:template>

	<xsl:template match="a:Author">
		<div style="margin-left: 20px;">
			<p><span class="field-label">Author ID:</span><span class="field-value"><xsl:value-of select="@Id"/></span></p>
			<p><span class="field-label">First Name:</span><span class="field-value"><xsl:value-of select="a:FirstName"/></span></p>
			<p><span class="field-label">Last Name:</span><span class="field-value"><xsl:value-of select="a:LastName"/></span></p>
			<p><span class="field-label">Age:</span><span class="field-value"><xsl:value-of select="a:Age"/></span></p>
		</div>
	</xsl:template>

	<xsl:template match="a:ArticleTag">
		<div class="comment-box">
			<p><span class="field-label">Tag ID:</span><span class="field-value"><xsl:value-of select="@Id"/></span></p>
			<p><span class="field-label">Name:</span><span class="field-value"><xsl:value-of select="a:Name"/></span></p>
			<p><span class="field-label">Article ID:</span><span class="field-value"><xsl:value-of select="a:ArticleId"/></span></p>
		</div>
	</xsl:template>

	<xsl:template match="a:Comment">
		<div class="comment-box">
			<p><span class="field-label">Comment ID:</span><span class="field-value"><xsl:value-of select="@Id"/></span></p>
			<p><span class="field-label">Body:</span><span class="field-value"><xsl:value-of select="a:Body"/></span></p>
			<p><span class="field-label">Article ID:</span><span class="field-value"><xsl:value-of select="a:ArticleId"/></span></p>
		</div>
	</xsl:template>

	<xsl:template match="a:Grade">
		<div class="comment-box">
			<p><span class="field-label">Article ID:</span><span class="field-value"><xsl:value-of select="a:ArticleId"/></span></p>
			<p><span class="field-label">Value:</span><span class="field-value"><xsl:value-of select="a:Value"/></span></p>
		</div>
	</xsl:template>

</xsl:stylesheet>
