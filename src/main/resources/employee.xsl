<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" indent="yes" />

    <xsl:template match="/Employees">
        <html>
            <head>
                <title>Employee list</title>
                <style>
                    table, th, td {
                    border:1px solid black;
                    }
                </style>
            </head>
            <body>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Gender</th>
                        <th>Age</th>
                        <th>Role</th>
                    </tr>
                    <xsl:for-each select="Employee">
                        <tr>
                            <td>
                                <xsl:value-of select="@id" />
                            </td>
                            <td>
                                <xsl:value-of select="name" />
                            </td>
                            <td>
                                <xsl:value-of select="gender" />
                            </td>
                            <td>
                                <xsl:value-of select="age" />
                            </td>
                            <td>
                                <xsl:value-of select="role" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>