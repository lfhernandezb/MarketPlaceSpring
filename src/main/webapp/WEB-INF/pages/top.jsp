<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Gesti&oacute;n Marketplace MiAuto</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<!--<link rel="stylesheet" type="text/css" href="css/base.css" />-->
<link rel="stylesheet" type="text/css" href="resources/css/jquery-ui-1.8.23.custom.css"  media="screen" charset="utf-8"/>
<!--<link rel="stylesheet" type="text/css" href="css/dialog.css" />-->
<!--<link rel="stylesheet" type="text/css" media="all" href="niceforms/niceforms-default.css" />-->
<!--link rel="stylesheet" type="text/css" media="all" href="nicejforms/css/niceforms-default.css" /-->
<link rel="stylesheet" type="text/css" media="all" href="resources/jsdatepick-calendar/jsDatePick_ltr.min.css" />

<!--<script type="text/javascript" src="js/jquery.min.js"></script>-->
<script type="text/javascript" src="resources/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.8.23.custom.min.js"></script>
<!--<script type="text/javascript" src="nicejforms/js/jquery.js"></script>-->
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/jconfirmaction.jquery.js"></script>
<script type="text/javascript" src="resources/js/ddaccordion.js"></script>
<!--<script type="text/javascript" src="niceforms/niceforms.js"></script>-->
<!--script type="text/javascript" src="nicejforms/js/nicejforms.js"></script-->
<script type="text/javascript" src="resources/jsdatepick-calendar/jsDatePick.jquery.min.1.3.js"></script>
<script type="text/javascript" src="resources/js/paginacion.js"></script>
<!--script type="text/javascript" src="resources/js/recrea_nf_select.js"></script-->

<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='resources/jimages/plus.gif' class='statusicon' />", "<img src='resources/jimages/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>

