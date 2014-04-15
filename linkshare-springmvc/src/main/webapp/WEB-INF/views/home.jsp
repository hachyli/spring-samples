<%@include file="taglib.jsp" %>

<html>
<head>
<style>
		body { font-size: 62.5%; }
		label, input { display:block; }
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		div#links-contain { width: 850px; margin: 20px 0; height: 400px;}
		div#links-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
		div#links-contain table td, div#links-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips { border: 1px solid transparent; padding: 0.3em; }
	</style>
	
	<script>

	function validateURL(textval) {
		  var urlregex = new RegExp(
		        "^(http:\/\/www.|https:\/\/www.|ftp:\/\/www.|www.){1}([0-9A-Za-z]+\.)");
		  return urlregex.test(textval);
		}
	
	$(function() {
		
		$( "#dialog-form" ).dialog({
			autoOpen: false,
			height: 300,
			width: 350,
			modal: true,
			buttons: {
				"Post": function() {
					var bValid = true;
					var title = $.trim($("#title").val());
					var url = $.trim($("#url").val());
					if(title=="" || url==""){
						alert('Please enter Title and URL.');
						bValid=false;
						return;
					}
					if(!validateURL(url)){
						alert('Invalid URL');
						bValid=false;
						return;
					}
					
					if ( bValid ) {
						$("#newLinkForm").submit();
						$( this ).dialog( "close" );
					}
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			},
			close: function() {
				allFields.val( "" ).removeClass( "ui-state-error" );
			}
		});
		
		$( "#create-link" ).button().click(function() {
				$( "#dialog-form" ).dialog( "open" );
		});
	});
	</script>
</head>
<body>
 	
 	<button id="create-link">Submit New Link</button>
 	
 	<div id="dialog-form" title="Submit New Link">
	<p class="validateTips">All form fields are required.</p>

	<form id="newLinkForm" action="secure/postLink.htm" method="post">
	<fieldset>
		<label for="title">Title</label>
		<input type="text" name="title" id="title" class="text ui-widget-content ui-corner-all" />
		<label for="url">URL</label>
		<input type="text" name="url" id="url" value="" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
	
</div>
	<div>
		${message}
	</div>

<div id="links-contain" class="ui-widget">
	<table class="ui-widget ui-widget-content">
		<thead>
		<tr class="ui-widget-header ">
			<th>Title</th>
			<th>PostedBy</th>	
			<th>PostedOn</th>
			
		</tr>
		</thead>
		<c:if test="${empty ALL_LINKS}">
		<tr>
			<td colspan="4">No Links found</td>
		</tr>
		</c:if>
		<c:if test="${! empty ALL_LINKS}">
			<c:forEach var="link" items="${ALL_LINKS}">		
		    <tr style="border: 1; border-collapse: collapse;">
				<td>
					<a href="${link.url}">${link.title}</a>
				</td>				
				<td><c:out value="${link.postedBy.firstname}"></c:out> </td>
				<td><fmt:formatDate value="${link.postedOn}" pattern="dd/MM/yyyy hh:mm:ss"/></td>				
			</tr>
			</c:forEach>
		</c:if>				
	</table>
	</div>
</body>
</html>