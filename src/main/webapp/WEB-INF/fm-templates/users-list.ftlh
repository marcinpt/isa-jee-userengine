<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>UsersList</title>
    <link type="text/css" rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
<p>
    <#list users>
        <ul>
            <#items as user><#sep>,<#else>None</#sep>

                <#if user.age < 21 >
                    <#assign class="blue">
                <#elseif user.age gt 20 && user.age < 41 >
                    <#assign class="green">
                <#else>
                    <#assign class="red">
                </#if>

                ${user.id}
                ${user.name}
                ${user.age}
                ${user.gender}
            </#items>
        </ul>
    </#list>
</p>

<#include "footer.ftlh">
</body>
</html>