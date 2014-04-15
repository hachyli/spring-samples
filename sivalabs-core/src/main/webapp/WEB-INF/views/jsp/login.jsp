
        <script type="text/javascript">
        	Ext.BLANK_IMAGE_URL = 'extjs/resources/images/default/s.gif';
        	Ext.onReady(function()
   			{
        		Ext.QuickTips.init();
   				var loginForm = new Ext.FormPanel({
   	   				id:'loginForm',
					renderTo: 'loginPanel',
					title: 'Login Form',
					url: 'login.do',
					frame: true,
					height: 150,
					width: 300,
					items:[
						{
							xtype: 'textfield',
							name : 'userName',
							fieldLabel : 'UserName',
							allowBlank: false,
							blankText : 'Please enter UserName',
							msgTarget:'side',
							emptyText:'UserName here'
							//msgTarget:'title'
							//msgTarget:'under'
							//,validationEvent:false
						},
						{
							xtype: 'textfield',
							inputType:'password',
							name : 'password',
							fieldLabel : 'Password',
							allowBlank: false,
							blankText: 'Please enter Password',
							minLength: 5,
							maxLength: 20,
							minLengthText: 'Password should be atleast 5 characters',
							maxLengthText: 'Password should be maximum of 20 characters',
							msgTarget:'side',
							//msgTarget:'title'
							//msgTarget:'under'
							//validationEvent:false,						
							listeners: {
								 specialkey: function(field, eventObj){
									 if (eventObj.getKey() == Ext.EventObject.ENTER) {
										 submitLoginForm();
									 }
								 }
							}
						}
					]
					,buttons: [
								{
									text: 'Login',
									handler : function(){
										 submitLoginForm();
									}
								},
								{
									text: 'Reset',
									handler : function(){
										loginForm.getForm().reset();
									}
								}

							 ]				
   	   				});

				
   				var loginSuccessHandler = function(form, action){
   					window.location = "page.do?view=welcome";
   	   			};

   				var loginFailureHandler = function(form, action){
   	   				if(action.result.errorMsg)
   					{
   	   					Ext.Msg.alert('Warning', 'Error:'+action.result.errorMsg);
   					}
   	   			};
	   	   		var submitLoginForm = function(){
		   	   		
					var loginForm = Ext.getCmp("loginForm");
					if(loginForm.getForm().isValid()){
						//alert('submitting to server');
						loginForm.getForm().submit({
							success: loginSuccessHandler,
							failure: loginFailureHandler
						});
					}
				};
   			});
        
        </script> 
    
    	<br/><br/><br/>
    	<center>
    		<div id="loginPanel"></div>
    	</center>
 