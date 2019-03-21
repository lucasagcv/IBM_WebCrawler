<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBM Web Crawler - Spring MVC</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css//style.css" rel="stylesheet">
</head>

<body>
    <div id="preloader">
        <div class="pre-container">
            <div class="spinner">
                <div class="double-bounce1"></div>
                <div class="double-bounce2"></div>
            </div>
        </div>
    </div>

    <div class="container-fluid">

        <section class="box-intro">
            <div class="table-cell">
                <h1 class="box-headline letters rotate-2">
                    <span class="box-words-wrapper">
                        <b class="is-visible">IBM .</b>
                        <b>Web_Crawler .</b>
                        <b>Spring_MVC .</b>
                    </span>
		        </h1>
            </div>

        </section>
    </div>

    <div class="portfolio-div">
        <Center>
            <div class="portfolio">
                <form action="/URL/controller.html">
                    WebSite URL: <input type="text" name="urlCrawler" value="">
                    <br>
                    MaxDepth: <input type="text" name="maxDepth" value="">
                    <br>
                    <input type="submit" value="Submit">
                    <br>
                </form>
                </div>
            </div>
        </Center>
    </div>


    <footer>
        <div class="container-fluid">
            <a href="/about/controller.html">About</a><br>
        </div>
    </footer>

    <script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/animated-headline.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/isotope.pkgd.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/modernizr.js"></script>

</body>

</html>