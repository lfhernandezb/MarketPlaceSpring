	<div class="header">
    <div class="logo">
    	<img src="resources/images/miauto.jpg" alt="" title="" border=0 width=50 height=50 />
    	<label style="font-size: 30px; font-weight: bold; color: #007398; position: relative; bottom: 13px;">MiAuto</label>
    	<div style="font-size: 12px; font-weight: bold;">CLACFactory</div>
    </div>
    <div class="right_header">
    <div style="color: #0E4354; font-size: 15px; font-weight: bold;">Gesti&oacute;n App MiAuto</div><br>
    Bienvenido ${pageContext.request.userPrincipal.name}, <!-- <a href="#">Visit site</a> | <a href="#" class="messages">(3) Messages</a> --> &nbsp;<a href="javascript:formSubmit()" class="logout">Logout</a></div>
    <div id="clock_a"></div>
    </div>

    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>

        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
