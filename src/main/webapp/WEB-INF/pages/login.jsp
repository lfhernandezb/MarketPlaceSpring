<%@ include file="top.jsp" %>

<script type="text/javascript" src="resources/js/login.js"></script>

</head>
<body>
<div id="main_container_login">

	<div class="header_login">
    	<div class="logo">
    		<img src="resources/images/miauto.jpg" alt="" title="" border=0 width=50 height=50 />
    		<label style="font-size: 30px; font-weight: bold; color: #007398; position: relative; bottom: 13px;">MiAuto</label>
    		<div style="font-size: 11px; font-weight: bold;">CLACFactory</div>
    	</div>
    	<!--
    	<div style="font-size: 13px; font-weight: bold; text-align: right;">Sistema de Gesti&oacute;n de Repuestos</div>
    	-->
    	
    	<div class="right_header_login">
		    <div style="font-size: 15px; font-weight: bold;">Gesti&oacute;n MiAuto</div>
	    </div>
	    
    </div>

     
    <div class="login_form">
         
         <h3>Ingreso</h3>
         <!--
         <a href="#" class="forgot_pass">Forgot password</a> 
         -->
         <form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST' class="niceform" id="login">
         
                <fieldset>
                    <dl>
                        <dt style="width: 190px;"><label for="usr">Nombre de Usuario:</label></dt>
                        <dd><input type="text" name="username" id="username" size="40" value="${username}" /></dd>
                    </dl>
                    <dl>
                        <dt style="width: 190px;"><label for="pwd">Contrase&ntilde;a:</label></dt>
                        <dd><input type="password" name="password" id="password" size="40" value="${password}" /></dd>
                    </dl>
                    
                    <dl>
                        <dt style="width: 190px;">
                        	<label></label>
                        </dt>
                        <dd>
                    		<input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Recordar mi nombre de usuario</label>
                        </dd>
                    </dl>
                    
                    <dl style="width: 500px;" class="submit">
                    	<input type="submit" name="submit" id="submit" value="Ingresar" />
                    </dl>
                    
                    <dl>
		                <c:if test="${not empty error}">
			                <label for="message" class="error">${error}</label>
		                </c:if>
		                <c:if test="${not empty message}">
			                <label for="message" class="message">${msg}</label>
		                </c:if>
                    </dl>
                </fieldset>
                
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         </form>
         </div>  
          
	
    <!--
    <div class="footer_login">
    
    	<div class="left_footer_login">IN ADMIN PANEL | Powered by <a href="http://indeziner.com">INDEZINER</a></div>
    	<div class="right_footer_login"><a href="http://indeziner.com"><img src="resources/images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>
    
    </div>
	-->
    <div class="footer_login">
    
    	<div class="left_footer">SiGREP | Sitio desarrollado por <a href="http://www.dsoft.cl">DSOFT EIRL</a></div>
    	<div class="right_footer"><a href="http://www.dsoft.cl"><img src="resources/images/logo_dsoft.jpg" alt="" title="" border="0" /></a></div>
    
    </div>
	
</div>		
</body>
</html>
