<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>

<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Index</title>

<link rel="stylesheet" type="text/css"
    href="<%=path %>/resources/ext-3.2.1/resources/css/ext-all.css" />

<!-- GC -->
<!-- LIBS -->
<script type="text/javascript"
    src="<%=path %>/resources/ext-3.2.1/adapter/ext/ext-base.js"></script>
<!-- ENDLIBS -->

<script type="text/javascript"
    src="<%=path %>/resources/ext-3.2.1/ext-all.js"></script>

<!--<script language="javascript" src="../grid/PropsGrid.js"></script>-->
<style type="text/css">
html,body {
    font: normal 12px verdana;
    margin: 0;
    padding: 0;
    border: 0 none;
    overflow: hidden;
    height: 100%;
}

.x-panel-body p {
    margin: 5px;
}

.x-column-layout-ct .x-panel {
    margin-bottom: 5px;
}

.x-column-layout-ct .x-panel-dd-spacer {
    margin-bottom: 5px;
}

.settings {
    background-image: url(<%=path %>/resources/img/folder_wrench.png)
        !important;
}

.nav {
    background-image: url(<%=path %>/resources/img/folder_go.png) !important;
}
</style>
<script type="text/javascript">

    Ext.onReady(function(){

       // NOTE: This is an example showing simple state management. During development,
       // it is generally best to disable state management as dynamically-generated ids
       // can change across page loads, leading to unpredictable results.  The developer
       // should ensure that stable state ids are set for stateful components in real apps.
       Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
       var tree1 = new Ext.tree.TreePanel({
           title:'test1',
           width:800,
           height:200,
           html:'1111'

           });
       var tree2 = new Ext.tree.TreePanel({
           title:'test2',
           width:800,
           height:200,
           html:'222'
           });
       var viewport = new Ext.Viewport({
            layout:'border',

            items:[
          /*  {
                region:'north',
                  id:'north-panel',
                  title:'north',
                  split:true,
                  hight: 60,
                  minSize: 175,
                  maxSize: 400,
                  collapsible: true,

                  layout:'accordion',
                  layoutConfig:{
                      animate:true
                  },
                  html:'asdfasdfafd'
              },
              */
            {
                region:'west',
                id:'west-panel',
                title:'导航',
                split:true,
                width: 200,
                minSize: 175,
                maxSize: 400,
                collapsible: true,
                margins:'35 0 5 5',
                cmargins:'35 5 5 5',
                layout:'accordion',
                layoutConfig:{
                    animate:true
                },
                expanded:true,
                items: [{
                    html: Ext.example.shortBogusMarkup,
                    title:'navigate',
                    autoScroll:true,
                    border:false,
                    expanded:true,
                    iconCls:'nav'
                },{
                    title:'report',
                    html: Ext.example.shortBogusMarkup,
                    border:false,
                    autoScroll:true,
                    expanded:true,
                    iconCls:'settings'
                }]
            },{
                region:'center',
                margins:'35 5 5 0',
                layout:'column',
                autoScroll:true,
                items:[{
                    columnWidth:.98,
                    columnHight:.80,
                    baseCls:'x-plain',
                    bodyStyle:'padding:5px 0 5px 5px',
                    items:[
                        tree1,tree2
                    ]
                },{
                    columnWidth:.98,
                    baseCls:'x-plain',
                    bodyStyle:'padding:5px',
                    items:[

                          {
                       title: 'B Panel',
                      html: Ext.example.bogusMarkup
                   }

                    ]
                }]
            }]
        });
    });
   </script>
</head>
<body>
<script type="text/javascript" src="<%=path %>/resources/js/examples.js"></script>
<jsp:include page="common/header.jsp" />
<!-- EXAMPLES -->
</body>
</html>
