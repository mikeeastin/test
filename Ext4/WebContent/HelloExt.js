/*Ext.application({
	name : 'HelloExt',
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'fit',
			items : [ {
				title : 'Hello Ext',
				html : 'Hello! Welcome to Ext JS.'
			} ]
		});
	}
});*/

/*Ext.onReady(function(){
 //	alert("hello  mike");
 Ext.get("myButton").on('click',function(){
 alert('you has click the button');
 });

 });*/

/*
 * Fit���֣���Ԫ�ؽ��Զ�������������������Ԫ�����ÿ����Ч�����������������ж����Ԫ�أ���ֻ����ʾ��һ����Ԫ�ء� 
 *
 * */Ext.application({
	name : "HelloExt",
	launch : function() {
		Ext.create('Ext.panel.Panel', {
			width : 1024,
			height : 720,
			layout : 'border',
			items : [ {
				region : 'south',
				xtype : 'panel',
				height : 20,
				split : false,
				html : '��ӭ�Ǐ�!',
				margins : '0 5 5 5'
			}, {
				title : 'West Region is collapsible',
				region : 'west',
				xtype : 'panel',
				margins : '5 0 0 5',
				width : 200,
				collapsible : true,
				id : 'west-region-container',
				layout : 'fit'
			}, {
				title : 'Center Region',
				region : 'center',
				xtype : 'panel',
				layout : 'fit',
				margins : '5 5 0 0',
				html : '��Extjs4�У�center�������ָ��������ᱨ��'
			} ],
			renderTo : Ext.getBody()
		});
	}
});