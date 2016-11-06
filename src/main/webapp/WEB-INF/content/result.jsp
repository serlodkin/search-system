<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<head>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">    <style>
        hgroup { padding-left: 15px; border-bottom: 1px solid #ccc; }
        hgroup h1 { font: 500 normal 1.625em "Roboto",Arial,Verdana,sans-serif; color: #2a3644; margin-top: 0; line-height: 1.15; }
        hgroup h2.lead { font: normal normal 1.125em "Roboto",Arial,Verdana,sans-serif; color: #2a3644; margin: 0; padding-bottom: 10px; }

        .search-result .thumbnail { border-radius: 0 !important; }
        .search-result:first-child { margin-top: 0 !important; }
        .search-result { margin-top: 20px; }
        .search-result .col-md-2 { border-right: 1px dotted #ccc; min-height: 140px; }
        .search-result ul { padding-left: 0 !important; list-style: none;  }
        .search-result ul li { font: 400 normal .85em "Roboto",Arial,Verdana,sans-serif;  line-height: 30px; }
        .search-result ul li i { padding-right: 5px; }
        .search-result .col-md-7 { position: relative; }
        .search-result h3 { font: 500 normal 1.375em "Roboto",Arial,Verdana,sans-serif; margin-top: 0 !important; margin-bottom: 10px !important; }
        .search-result h3 > a, .search-result i { color: #248dc1 !important; }
        .search-result p { font: normal normal 1.125em "Roboto",Arial,Verdana,sans-serif; }
        .search-result span.plus { position: absolute; right: 0; top: 126px; }
        .search-result span.plus a { background-color: #248dc1; padding: 5px 5px 3px 5px; }
        .search-result span.plus a:hover { background-color: #414141; }
        .search-result span.plus a i { color: #fff !important; }
        .search-result span.border { display: block; width: 97%; margin: 0 15px; border-bottom: 1px dotted #ccc; }
    </style>
</head>
<body>
    <form  style="margin-left:auto;margin-right:auto;margin-top:auto;margin-bottom:auto" action="result.action">
        <input name="searchQuery" id="searchQuery">
        <input type="submit" class="btn btn-success">
    </form>


    <div class="container">

        <hgroup class="mb20">
            <h1>Search Results</h1>
            <h2 class="lead"><strong class="text-danger"><s:property value="%{result.size}"/> </strong> results were found for the search for <strong class="text-danger"><s:property value="%{searchQuery}"/></strong></h2>
        </hgroup>

        <section class="col-xs-12 col-sm-6 col-md-12">
            <s:iterator value="result" var="link1">

            <article class="search-result row">
                <div class="col-xs-12 col-sm-12 col-md-3">
                    <a class="thumbnail" href=<s:property value="link"/>><s:property value="title"/></a>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-7 excerpet">
                    <h3><a class="thumbnail" href=<s:property value="link"/>><s:property value="title"/></a></h3>
                    <p><s:property value="description"/></p>
                </div>
            </article>
            </s:iterator>
        </section>
    </div>
</body>
