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
 * Fit布局，子元素将自动填满整个父容器（对元素设置宽度无效），如果容器组件中有多个子元素，则只会显示第一个子元素。 
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
				html : '欢迎登弽!',
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
				html : '在Extjs4中，center区域必项指定，否则会报错。'
			} ],
			renderTo : Ext.getBody()
		});
	}
});