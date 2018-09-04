<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>
    Welcome ${user}<#if user == "Alex">, our favourite teacher</#if>!
</h1>
<p>getRequestUrl(): <i>${requrl}</i>
<p>getRequestURI(): <i>${path}</i>
<p>getQueryString(): <i>${params}</i>
<p>Our latest product: <a href="${latestProduct.url}">${latestProduct.name}</a> !
<p><table border=1>
    <#list items as i>
    <tr><td>${i.id}</td><td>${i.name}</td><td><#if i.price=="0.00">free<#else>${i.price}</#if></td></tr>
    </#list>
</table>
</body>
</html>