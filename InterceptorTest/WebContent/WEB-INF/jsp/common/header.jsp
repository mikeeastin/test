<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>navigate</title>
<link href="<%=path %>/resources/css/navigateStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/jquery.min.js"></script>
<script language="javascript">
        $(document).ready(function() {

            /*  2nd example */

            $("#menu2 li a").wrapInner( '<span class="out"></span>' );

            $("#menu2 li a").each(function() {
                $( '<span class="over">' +  $(this).text() + '</span>' ).appendTo( this );
            });

            $("#menu2 li a").hover(function() {
                $(".out",   this).stop().animate({'top':    '40px'},    300); // move down - hide
                $(".over",  this).stop().animate({'top':    '0px'},     300); // move down - show

            }, function() {
                $(".out",   this).stop().animate({'top':    '0px'},     300); // move up - show
                $(".over",  this).stop().animate({'top':    '-40px'},   300); // move up - hide
            });

        });

    </script>
</head>
<body>
<div>

<div id="menu2" class="menu">
    <ul>
    <li><a href="#">Home</a></li>
    <li><a href="#">Sourcing</a></li>
    <li><a href="#">Order</a></li>
    <li><a href="#">QM</a></li>
    <li><a href="#">QC</a></li>
    <li><a href="#">Vendor Mgmt</a></li>
    <li><a href="verificationCode">Setup</a></li>
    </ul>
    <div class="cls"></div>
</div>
</div>
</body>
</html>
