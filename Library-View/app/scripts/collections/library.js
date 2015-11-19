/**
 * Created by krido02 on 11/12/2015.
 */

var app = app || {};

app.Library = Backbone.Collection.extend({

    model: app.Book,
    url: 'http://localhost:8180/library/books'
    //url: '/library/books'

});