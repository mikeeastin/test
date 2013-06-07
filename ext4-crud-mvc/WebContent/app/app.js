/**
 * Ext JS Library 4.0.0

 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 *
 * Sample project presented at BrazilJS
 * Brazilian JavaScript Conference
 * Fortaleza - Cear�- 13-14 May 2011
 * http://braziljs.com.br/2011
 *
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
Ext.Loader.setConfig({enabled:true});//开启动态加载

Ext.application({
    name: 'BrazilJS',

    controllers: [
        'Contacts'
    ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'contactlist'
/*                    xtype:'panel',
                    title: 'Users',
                    html : 'List of users will go here'*/
                }
            ]
        });
    }
});
