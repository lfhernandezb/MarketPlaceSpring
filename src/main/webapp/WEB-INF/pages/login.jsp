<{include file="top.html"}>

<script type="text/javascript" src="js/login.js"></script>

</head>
<body>
<div id="main_container_login">

	<div class="header_login">
    	<div class="logo">
    		<img src="images/miauto.jpg" alt="" title="" border=0 width=50 height=50 />
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
         <form action="<{$receiver}>?do=Login&destino=<{$target}>" method="post" class="niceform" id="login">
         
                <fieldset>
                    <dl>
                        <dt style="width: 190px;"><label for="usr">Nombre de Usuario:</label></dt>
                        <dd><input type="text" name="usr" id="usr" size="40" value="<{$usr}>" /></dd>
                    </dl>
                    <dl>
                        <dt style="width: 190px;"><label for="pwd">Contrase&ntilde;a:</label></dt>
                        <dd><input type="password" name="pwd" id="pwd" size="40" value="<{$pwd}>" /></dd>
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
	                    <label for="message" class="error"><{$status_message}></label>
                    </dl>
                </fieldset>
                
         </form>
         </div>  
          
	
    <!--
    <div class="footer_login">
    
    	<div class="left_footer_login">IN ADMIN PANEL | Powered by <a href="http://indeziner.com">INDEZINER</a></div>
    	<div class="right_footer_login"><a href="http://indeziner.com"><img src="images/indeziner_logo.gif" alt="" title="" border="0" /></a></div>
    
    </div>
	-->
    <div class="footer_login">
    
    	<div class="left_footer">SiGREP | Sitio desarrollado por <a href="http://www.dsoft.cl">DSOFT EIRL</a></div>
    	<div class="right_footer"><a href="http://www.dsoft.cl"><img src="images/logo_dsoft.jpg" alt="" title="" border="0" /></a></div>
    
    </div>
	
</div>		
</body>
</html>
