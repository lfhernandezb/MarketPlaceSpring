<!--jsp:include page="top.html" flush="true"-->
<%@ include file="top.jsp" %>

<script type="text/javascript">

	$(document).ready(function() {
	<c:choose>
		<c:when test="${exito != null}">
		
			<c:if test="${exito}">
    							
    			var choices;
				var data;
				var sel_plataforma;
				var sel_region;
				var sel_ciudad;
				var sel_fabricante;
				var sel_motivo;
				var sel_usuario;
				var sel_tipo;
			
				// selecciono los itemes elegidos pre submit
				
				sel_plataforma = $('#sel_plataforma').val();
				
				if (sel_plataforma != 0) { 
					$('#plataforma').val(sel_plataforma);
				}
				
				sel_region = $('#sel_region').val();
				
				if (sel_region != 0) {
					$('#region').val(sel_region);
		
					// cargo las ciudades presentes presubmit; las opciones se graban en la sesion en comando Ajax
					choices = '';
		         	choices += "<option value=\"\" selected=\"selected\">Ciudad</option>";
		
					<c:if test="${options_ciudades != null}">	
						data = <{$options_ciudades}>;
			             
		
			            $.each(data.ciudades, function(index, ciudad) {
			                choices += "<option value=\"" + ciudad.id.toString() + "\">";
			                choices += ciudad.descripcion.toString();
			                choices += "</option>";
			            });
					</c:if>
		         
					// elimino el contenido del control
					 $('#ciudad').text('');
					 // agrego las opciones al combobox
					 $(choices).appendTo('#ciudad');
					// dejo seleccionado el mismo pre submit
					
					sel_ciudad = $('#sel_ciudad').val();
					
					if (sel_ciudad != 0) {
			            $('#ciudad').val(sel_ciudad);
		
						// cargo las R/E presentes presubmit; las opciones se graban en la sesion en comando Ajax
						choices = '';
			            choices += "<option value=\"\" selected=\"selected\">R/E</option>";
		
						<c:if test="${options_res != null}">	
							data = <{$options_res}>;
			
				            $.each(data.res, function(index, re) {
				                choices += "<option value=\"" + re.id.toString() + "\">";
				                choices += re.descripcion.toString();
				                choices += "</option>";
				            });
			            </c:if>
			            
			            $('#re').text('');
			            $(choices).appendTo('#re');
		
			            $('#re').val($('#sel_re').val());
					}
				}
		
				sel_fabricante = $('#sel_fabricante').val();
				
				if (sel_fabricante != 0) {
				
					$('#fabricante').val(sel_fabricante);
		
					// cargo los modelos presentes presubmit; las opciones se graban en la sesion en comando Ajax
					choices = '';
		         	choices += "<option value=\"\" selected=\"selected\">Modelo</option>";
		
					<c:if test="{$options_modelos != null}">	
						data = <{$options_modelos}>;
			             	
			            $.each(data.modelos, function(index, modelo) {
			                choices += "<option value=\"" + modelo.id.toString() + "\">";
			                choices += modelo.pid.toString()+'  '+modelo.descripcion.toString();
			                choices += "</option>";
			            });
		         	</c:if>
		         
					//choices += "</select>";
					
					//alert(choices.toString());
					
					$('#modelo').text('');
					$(choices).appendTo('#modelo');
					
					$('#modelo').val($('#sel_modelo').val());
				}
		     
		
			</c:if>
		
			//$('#id_razon').parent().parent().parent().show();
		</c:when>
		<c:otherwise>
			$('#comuna').attr('disabled', true);
		
			$('#modelo').attr('disabled', true);
								
		</c:otherwise>
	</c:choose>

			$('#region').change(function() {
				// al cambiar la region por algo valido, debo cargar en el combo de comunas que le pertenecen
				// si se selecciona 'Region', debo descargar comunas
				var output;
				var opt;
				var choices;
				var sel = $(this).val().toString();
				
				// alert(sel);
				
				if ($(this).hasClass('error')) {
					$(this).removeClass('error');
					$('.error').remove();
				}

				if (sel == 0) {
					// elegido titulo
					
					// genero opciones de combo de comunas
		            choices = '';
		            choices += "<option value=\"\" selected=\"selected\">Comuna</option>";

					// deshabilito select de comunas
					$('#comuna').attr('disabled', true);					
				}
				else {
					// region valida del combo
					var json = {}
					json["idRegion"] = sel.toString();					
									
					// genero opciones de select comuna
		            $.ajax({
		                async: false,
		                type: 'POST',
		                url: "${home}getComunas",
		                contentType : 'application/json; charset=utf-8',
		                dataType: 'json',
		                data : JSON.stringify(json),
		                timeout : 30000,
		                
		                error: function(xhr){
		                 	if (xhr.status == 401) {
		                 		// sesion expirada, redirijo a login
		                 		window.location = "<{$receiver}>";
		                 	}
		                 	else {
		                 		// error en ajax
		                	    alert("An error occured: " + xhr.status + " " + xhr.statusText);
		                 	}
		                },
		                success: function(output_string){
		                	//alert(output_string);
		                    output = output_string;
		                }
		            });

		            //alert(data.ciudades);
		            
					choices = '';
		            //var choices = "<select size=\"1\" name=\"ciudad\" id=\"ciudad\" >"; 
		            choices += "<option value=\"\" selected=\"selected\">Comuna</option>";

		            $.each(output.comunas, function(index, comuna) {
		                choices += "<option value=\"" + comuna.idComuna.toString() + "\">";
		                choices += comuna.descripcion.toString();
		                choices += "</option>";
		            });
		            
		            //choices += "</select>";

		            //alert(choices.toString());
		            
					// habilito select (y niceform) de ciudades
					$('#comuna').attr('disabled', false);
				}
				
				// agrego las opciones generadas al select de ciudades
	            $('#comuna').text('');
	            $(choices).appendTo('#comuna');	            
			}); // end change

			$('#fabricante').change(function() {
				// al cambiar el fabricante debo cargar en el combo de modelos los que le pertenecen
				var data;
				var sel = $('#fabricante').val().toString();
				
				// alert(sel);
				
				if ($(this).hasClass('error')) {
					$(this).removeClass('error');
					$('.error').remove();
				}

				if (sel == 0) {
					// seleccionado titulo
		            
		            // genero opcion para select modelo
		            choices = '';
		            choices += "<option value=\"\" selected=\"selected\">Modelo</option>";

					// deshabilito select (y niceform) de modelo
					$('#modelo').attr('disabled', true);
					
					// muestro select niceform modelo
					$('#modelo').parent().parent().show();
				}
				else {
					// fabricante valido en combo
					
					// genero opciones de modelo
		            $.ajax({
		                async: false,
		                url: "<{$receiver}>?do=Ajax&req=getModelos&id_fabricante=" + sel,
		                type: 'GET',
		                dataType: 'json',
		                error: function(xhr){
		                 	if (xhr.status == 401) {
		                 		// sesion expirada, redirijo a login
		                 		window.location = "<{$receiver}>";
		                 	}
		                 	else {
		                 		// error en ajax
		                	    alert("An error occured: " + xhr.status + " " + xhr.statusText);
		                 	}
		                },
		                success: function(output_string){
		                	//alert(output_string);
		                    data = output_string;
		                }
		            });

		            //alert(data.modelos);
		            
					var choices = '';
		            //var choices = "<select size=\"1\" name=\"ciudad\" id=\"ciudad\" >"; 
		            choices += "<option value=\"\" selected=\"selected\">Modelo</option>";

		            $.each(data.modelos, function(index, modelo) {
		                choices += "<option value=\"" + modelo.id.toString() + "\">";
		                choices += modelo.pid.toString()+' '+modelo.descripcion.toString();
		                choices += "</option>";
		            });
		            
		            //choices += "</select>";

		            //alert(choices.toString());

					// habilito select (y niceform) modelo
					$('#modelo').attr('disabled', false);
					
		            // muestro select niceform de modelo
		            $('#modelo').parent().parent().show();

				}
				
				// agrego opciones a select modelo
	            $('#modelo').text('');
	            $(choices).appendTo('#modelo');
				
				// re-genero select niceform modelo
				recrea_nf_select($('#modelo'), 5);
				
			}); // end change
			
			$('.confirm').click(function(e) {
				var self = this;
				
				var id_proveedor = $(this).attr('href');

				e.preventDefault();
				
			    if($(this).next('div.question').length <= 0)  
			        $(this).after('<div class="question">Est&aacute; seguro?<br> <span class="yes">S&iacute;</span><span class="cancel">Cancelar</span></div>');  
				
				$(this).next('.question').animate({opacity: 1}, 300);
				
				$('.yes').bind('click', function(){
					var data;
					var str;
					
			        $.ajax({
			             async: false,
			             url: "<{$receiver}>?do=Ajax&req=delProveedor&id_proveedor=" + id_proveedor,
			             type: 'GET',
			             dataType: 'json',
			             error: function(xhr){
			              	if (xhr.status == 401) {
			             		// sesion expirada, redirijo a login
			             		window.location = "<{$receiver}>";
			             	}
			             	else {
			             		// error en ajax
			            	    alert("An error occured: " + xhr.status + " " + xhr.statusText);
			             	}
			             },
			             success: function(output_string){
			             	//alert(output_string);
			                 data = output_string;
			             }
			        });
			
			        if (data.respuesta == '1') {
			        	$(self).parent().parent().hide();
			        }
				});
		
				$('.cancel').bind('click', function(){
					$(this).parents('.question').fadeOut(300, function() {
						$(this).remove();
					});
				});
				
			});
			
		// texto en USER HELP DESK
		$('.sidebar_box p').html('<{$user_help_desk}>');
			
	}); // end ready

	function detalleProveedor(id_proveedor) {
		// consulto los detalles del proveedor
		var data;
		var str;
		
        $.ajax({
             async: false,
             url: "<{$receiver}>?do=Ajax&req=getProveedor&id_proveedor=" + id_proveedor,
             type: 'GET',
             dataType: 'json',
             error: function(xhr){
             	if (xhr.status == 401) {
             		// sesion expirada, redirijo a login
             		window.location = "<{$receiver}>";
             	}
             	else {
             		// error en ajax
            	    alert("An error occured: " + xhr.status + " " + xhr.statusText);
             	}
             },
             success: function(output_string){
             	//alert(output_string);
                 data = output_string;
             }
        });

		str =
			'<table>'+
			'  <tr>'+
			'    <th align="left">Plataforma</h>'+
			'    <td>'+data.proveedor.plataforma+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Regi&oacute;n</h>'+
			'    <td>'+data.proveedor.region+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Ciudad</h>'+
			'    <td>'+data.proveedor.ciudad+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">R/E</h>'+
			'    <td>'+data.proveedor.radio_estacion+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Fabricante</h>'+
			'    <td>'+data.proveedor.fabricante+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Modelo</h>'+
			'    <td>'+data.proveedor.modelo+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">SAP</h>'+
			'    <td>'+data.proveedor.sap+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Serial</h>'+
			'    <td>'+data.proveedor.serial+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Nombre</h>'+
			'    <td>'+data.proveedor.nombre+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">SLA</h>'+
			'    <td>'+data.proveedor.sla+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Encargado</h>'+
			'    <td>'+data.proveedor.encargado+'</td>'+
			'  </tr>'+
			'  <tr>'+
			'    <th align="left">Cantidad</h>'+
			'    <td>'+data.proveedor.cantidad+'</td>'+
			'  </tr>'+
			'</table>';

		$('#p1').html(str);
		
		$('#dialog').dialog('open');
	}	


</script>

<script type="text/javascript" src="resources/js/display_home.js"></script>
	
</head>
<body>
<!-- the dialog contents -->
<div id="dialog" title="Detalle de Proveedor">
	<div id="p1"></div>
</div>

<!-- export form -->
<form action="<{$receiver}>?do=ExportarHome" method="post" id="export">
	<!--
	<input type="hidden" name="plataforma" id="export_plataforma" />
	<input type="hidden" name="region" id="export_region" />
	<input type="hidden" name="ciudad" id="export_ciudad" />
	<input type="hidden" name="re" id="export_re" />
	<input type="hidden" name="fabricante" id="export_fabricante" />
	<input type="hidden" name="modelo" id="export_modelo" />
	-->
</form>

<div id="main_container">

	<!--jsp:include page="header.html" flush="true"-->
	<%@ include file="header.jsp" %>
    
    <div class="main_content">
    
    <!--jsp:include page="upper_menu.html" flush="true"-->
    <%@ include file="upper_menu.jsp" %>           
                    
    <div class="center_content">  
    
    
    
    <div class="left_content">
    
    		<div class="sidebar_search">
	            <form action="<{$receiver}>?do=home.jsp" method="post" id="buscar" "niceform">
		            <!-- <input type="text" name="search_keyword" class="search_input" value="search keyword" onclick="this.value=''" /> -->
		            <input type="text" name="search_keyword" id="search_keyword" class="search_input" value="<{$search_keyword}>" />
		            <input type="image" class="search_submit" src="resources/images/search.png" />
	            </form>            
            </div>
    
            <div class="sidebarmenu">
            	<!--
                <a class="menuitem submenuheader" href="">Plataformas</a>
                <div class="submenu">
                    <ul>
                    
                    <li><a href=""><AAAA></a></li>
                    <li><a href=""><BBBB></a></li>
                    <li><a href=""><CCCC></a></li>
                    
                   </ul>
                </div>
                <a class="menuitem submenuheader" href="" >Sidebar Settings</a>
                <div class="submenu">
                    <ul>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    </ul>
                </div>
                 
                <a class="menuitem submenuheader" href="">Add new products</a>
                <div class="submenu">
                    <ul>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    <li><a href="">Sidebar submenu</a></li>
                    </ul>
                </div>
                
                <a class="menuitem" href="">User Reference</a>
                -->
                <!--
                <a class="menuitem" href="">Blue button</a>
                
                <a class="menuitem_green" href="">Green button</a>
                -->
                
				<{if $puedeAgregar}>
					<a class="menuitem" href="<{$receiver}>?do=AgregaProveedor">Agregar Proveedor Manual</a>
				<{/if}>
                
				<{if $puedeAgregar}>
					<a class="menuitem" href="<{$receiver}>?do=AgregaProveedorMasivo">Agregar Proveedor Masivo</a>
				<{/if}>
                               
                <a class="menuitem" href="<{$receiver}>?do=ReporteActividad">Reporte Actividad</a>
                
                <a class="menuitem" href="<{$receiver}>?do=ReporteExistencias">Existencias por Zona</a>

                <a class="menuitem" href="<{$receiver}>?do=ReporteExistenciasPorRegion">Existencias por Regi&oacute;n</a>

		        <{if (isset($exito) && $row_number > 0)}>
		           <{if $exito}>
		        		<a class="menuitem_green" href="#" onclick="javascript:exportar()">Exportar a Excel</a>
					<{/if}>
				<{/if}>
            </div>
            
            <!--jsp:include page="sidebar_box.html" flush="true"-->
            <%@ include file="sidebar_box.jsp" %>
            
            <!--
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h4>Important notice</h4>
                <img src="images/notice.png" alt="" title="" class="sidebar_icon_right" />
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            
            -->
            <!--
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h5>Download photos</h5>
                <img src="images/photo.png" alt="" title="" class="sidebar_icon_right" />
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>  
            -->
            <!--
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h3>To do List</h3>
                <img src="images/info.png" alt="" title="" class="sidebar_icon_right" />
                <ul>
                <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                 <li>Lorem ipsum dolor sit ametconsectetur <strong>adipisicing</strong> elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</li>
                  <li>Lorem ipsum dolor sit amet, consectetur <a href="#">adipisicing</a> elit.</li>
                   <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                    <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                     <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                </ul>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            --> 
    
    </div>  
    
    <div class="right_content">            
        
    	<h2>B&uacute;squeda de Proveedores</h2>
    
 		<div class="form">
         	<form action="<{$receiver}>?do=home.jsp" method="post" class="niceform" id="edita_usuario">
				<input type="hidden" name="sel_plataforma" id="sel_plataforma" value="<{$plataforma}>" />
				<input type="hidden" name="sel_region" id="sel_region" value="<{$region}>" />
				<input type="hidden" name="sel_ciudad" id="sel_ciudad" value="<{$ciudad}>" />
				<input type="hidden" name="sel_re" id="sel_re" value="<{$re}>" />
				<input type="hidden" name="sel_fabricante" id="sel_fabricante" value="<{$fabricante}>" />
				<input type="hidden" name="sel_modelo" id="sel_modelo" value="<{$modelo}>" />
				<fieldset>
                    <dl>
                        <dt><label for="region">Regi&oacute;n:</label></dt>
                        <dd>
                            <select size="1" name="region" id="region" value="<{$region}>">
                                <option value="">Regi&oacute;n</option>
								
								<c:forEach var="region" items="#{listRegiones}">
								    <option value="${region.idRegion}">${region.descripcion}</option>
								</c:forEach>                            
								  
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="comuna">Comuna:</label></dt>
                        <dd>
                            <select size="1" name="comuna" id="comuna" value="<{$comuna}>">
                                <option value="">Comuna</option>
								
								<c:forEach var="comuna" items="#{listComunas}">
								    <option value="${comuna.idComuna}">${comuna.descripcion}</option>
								</c:forEach>                            
                                
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="re">R/E:</label></dt>
                        <dd>
                            <select size="1" name="re" id="re" value="<{$re}>">
                                <option value="">R/E</option>
                                
                                
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="fabricante">Fabricante:</label></dt>
                        <dd>
                            <select size="1" name="fabricante" id="fabricante" value="<{$fabricante}>">
                                <option value="">Fabricante</option>
                                
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="modelo">Modelo:</label></dt>
                        <dd>
                            <select size="1" name="modelo" id="modelo" value="<{$modelo}>">
                                <option value="">Modelo</option>
                                
                                
                            </select>
                        </dd>
                    </dl>
                    <dl class="submit">
                    	<input type="submit" name="submit" id="submit" value="Buscar" />
                    </dl>
    
    			</fieldset>
    		</form>
         </div>           
                    
		<!-- the input fields that will hold the variables we will use -->  
		<input type='hidden' id='current_page' />  
		<input type='hidden' id='show_per_page' />  

	<table id="rounded-corner">
    <thead>
    	<tr>
       		<th scope="col" class="rounded-company">Plat</th>
<!-- 			<th scope="col" class="rounded">Plat</th> -->
            <th scope="col" class="rounded">Fab</th>
            <th scope="col" class="rounded" >Modelo</th>
            <th scope="col" class="rounded">Reg</th>
            <th scope="col" class="rounded">Ciudad</th>
            <th scope="col" class="rounded">R/E</th>
<!--            <th scope="col" class="rounded">Ut</th>-->
			<th scope="col" class="rounded-q4">Acciones&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            
        </tr>
    </thead>
        <tfoot>
    	<tr>
		        <{if isset($exito)}>
		           <{if $exito}>
		        		<td colspan="6" class="rounded-foot-left"><em>La b&uacute;squeda arroj&oacute; <{$row_number}> registro(s).</em></td>
					<{/if}>
				<{else}>
					<td colspan="6" class="rounded-foot-left"><em>&nbsp;</em></td>
				<{/if}>
        	<td class="rounded-foot-right">&nbsp;</td>

        </tr>
    </tfoot>
    <tbody>
    	<!--
    	<block start="resultBlock"/>
    	
    	<loop start="search_result"/>
    	<tr>
            <td>{search_result.plataforma}</td>
            <td>{search_result.fabricante}</td>
            <td>{search_result.modelo}</td>
            <td>{search_result.radio_estacion}</td>
            <td>{search_result.ciudad}</td>
            <td>{search_result.region}</td>
			
			<td>
				<block start="puedeUtilizar"/>
					<a href="{t_receiver.main}?do=UtilizaProveedor&id={search_result.id}"><img src="resources/images/user_edit.png" alt="Utiliza Proveedor" title="" border="0" /></a>
				<block end="puedeUtilizar"/>
	            
				<block start="puedeEliminar"/>
					<a href="{t_receiver.main}?do=EliminaProveedor&id={search_result.id}" class="ask"><img src="resources/images/trash.png" alt="Elimina Proveedor" title="" border="0" /></a>
				<block end="puedeEliminar"/>
            </td>
        </tr>
        <loop end="search_result"/>
        
        <block end="resultBlock"/>
        -->
        <{forea from=$search_result item=proveedor}>
        <tr>	
            <td><{$proveedor.plataforma}></td>
            <td><{$proveedor.fabricante}></td>
            <td><{$proveedor.modelo|htmlentities}></td>
            <td><{$proveedor.region}></td>
            <td><{$proveedor.ciudad|htmlentities}></td>
            <td><{$proveedor.radio_estacion|htmlentities}></td>
			
			<td>
				<a href="#" onClick="detalleProveedor(<{$proveedor.id}>); return false"><img src="resources/images/detail.png" alt="Detalle" title="Detalle" border="0" /></a>

				<{if ($usuario_aplicacion->nombre_usuario == 'admin')}>
					<a href="<{$receiver}>?do=EditaModelo&id=<{$proveedor.id_modelo}>"><img src="resources/images/edit.png" alt="Edita Modelo" title="Edita Modelo" border="0" /></a>
				<{/if}>
				
				<{if $puedeUtilizar}>
					<a href="<{$receiver}>?do=UtilizaProveedor&id=<{$proveedor.id}>"><img src="resources/images/use.png" alt="Utiliza Proveedor" title="Utiliza Proveedor" border="0" /></a>
				<{/if}>
	            
				<{if $puedeMover}>
					<a href="<{$receiver}>?do=MueveProveedor&id=<{$proveedor.id}>"><img src="resources/images/move.png" alt="Mueve Proveedor" title="Mueve Proveedor" border="0" /></a>
				<{/if}>
				
				<{if $puedeEliminar}>
					<!--<a href="<{$receiver}>?do=EliminaProveedor&id=<{$proveedor.id}>" class="ask"><img src="resources/images/trash.png" alt="Elimina Proveedor" title="" border="0" /></a>-->
					<a href="<{$proveedor.id}>" class="confirm"><img src="resources/images/trash.png" alt="Elimina Proveedor" title="Elimina Proveedor" border="0" /></a>
				<{/if}>
            </td>
            
        </tr>
        <{/foreach}>                    
        
    </tbody>
</table>
	<!--
	<block start="puedeAgregar"/>
		<a href="{t_receiver.main}?do=AgregaProveedor" class="bt_green"><span class="bt_green_lft"></span><strong>Agregar</strong><span class="bt_green_r"></span></a>
	<block end="puedeAgregar"/>
	-->
	
	<!-- movido a left_content
	<{if $puedeAgregar}>
		<a href="<{$receiver}>?do=AgregaProveedor" class="bt_green"><span class="bt_green_lft"></span><strong>Agregar</strong><span class="bt_green_r"></span></a>
	<{/if}>
	-->
    <!--
     <a href="#" class="bt_blue"><span class="bt_blue_lft"></span><strong>View all items from category</strong><span class="bt_blue_r"></span></a>
     <a href="#" class="bt_red"><span class="bt_red_lft"></span><strong>Delete items</strong><span class="bt_red_r"></span></a> 
     
     -->
     
       <{if isset($exito)}>
          <{if $exito && $row_number > 0}>
          		<!-- An empty div which will be populated using jQuery -->
	        <div class="pagination">
	        <!--<span class="disabled"><< prev</span><span class="current">1</span><a href="">2</a><a href="">3</a><a href="">4</a><a href="">5</a>…<a href="">10</a><a href="">11</a><a href="">12</a>...<a href="">100</a><a href="">101</a><a href="">next >></a>-->
	        </div> 
		<{/if}>
	<{/if}>
     
    
	<!-- An empty div which will be populated using jQuery -->  
	<!-- <div id='page_navigation'></div>  -->
	       
     <!--
     <h2>Warning Box examples</h2>
      
     <div class="warning_box">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.
     </div>
     <div class="valid_box">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.
     </div>
     <div class="error_box">
        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.
     </div>  
    -->
    <!--  
     <h2>Nice Form example</h2>
     
         <div class="form">
         <form action="" method="post" class="niceform">
         
                <fieldset>
                    <dl>
                        <dt><label for="email">Email Address:</label></dt>
                        <dd><input type="text" name="" id="" size="88.8" /></dd>
                    </dl>
                    <dl>
                        <dt><label for="password">Password:</label></dt>
                        <dd><input type="text" name="" id="" size="88.8" /></dd>
                    </dl>
                    
                    
                    <dl>
                        <dt><label for="gender">Select categories:</label></dt>
                        <dd>
                            <select size="1" name="gender" id="">
                                <option value="">Select option 1</option>
                                <option value="">Select option 2</option>
                                <option value="">Select option 3</option>
                                <option value="">Select option 4</option>
                                <option value="">Select option 5</option>
                            </select>
                        </dd>
                    </dl>
                    <dl>
                        <dt><label for="interests">Select tags:</label></dt>
                        <dd>
                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Web design</label>
                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Business</label>
                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Simple</label>
                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">Clean</label>
                        </dd>
                    </dl>
                    
                    <dl>
                        <dt><label for="color">Select type</label></dt>
                        <dd>
                            <input type="radio" name="type" id="" value="" /><label class="check_label">Basic</label>
                            <input type="radio" name="type" id="" value="" /><label class="check_label">Medium</label>
                            <input type="radio" name="type" id="" value="" /><label class="check_label">Premium</label>
                        </dd>
                    </dl>
                    
                    
                    
                    <dl>
                        <dt><label for="upload">Upload a File:</label></dt>
                        <dd><input type="file" name="upload" id="upload" /></dd>
                    </dl>
                    
                    <dl>
                        <dt><label for="comments">Message:</label></dt>
                        <dd><textarea name="comments" id="comments" rows="5" cols="36"></textarea></dd>
                    </dl>
                    
                    <dl>
                        <dt><label></label></dt>
                        <dd>
                            <input type="checkbox" name="interests[]" id="" value="" /><label class="check_label">I agree to the <a href="#">terms &amp; conditions</a></label>
                        </dd>
                    </dl>
                    
                     <dl class="submit">
                    <input type="submit" name="submit" id="submit" value="Submit" />
                     </dl>
                     
                     
                    
                </fieldset>
                
         </form>
         </div>  
      -->
     
     </div><!-- end of right content-->
            
                    
  </div>   <!--end of center content -->               
                    
                    
    
    
    <div class="clear"></div>
    </div> <!--end of main content-->
	
    
    <!--jsp:include page="footer.html" flush="true"-->
    <%@ include file="footer.jsp" %>

</div>		
</body>
</html>
