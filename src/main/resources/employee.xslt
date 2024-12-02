<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:strip-space elements="*"/>
    <xsl:output method="xml" encoding="UTF-8" indent="no"/>

    <xsl:template match="/Employees">
        <Employees>
                    <xsl:for-each select="Employee">
                        <xsl:sort select="name"/>
                        <Employee>
                            <id><xsl:value-of select="@id" /></id>
                            <name><xsl:value-of select="name" /></name>
                            <gender><xsl:value-of select="gender" /></gender>
                            <age><xsl:value-of select="age" /></age>
                            <role><xsl:value-of select="role" /></role>
                        </Employee>
                    </xsl:for-each>
        </Employees>
    </xsl:template>
</xsl:stylesheet>