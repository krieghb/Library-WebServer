/**
 * Created by krido02 on 11/12/2015.
 */

var app = app || {};

app.Book = Backbone.Model.extend({
    defaults: {
        coverImage: 'images/placeholder.png',
        title: 'No Title',
        author: 'Unknown',
        releaseDate: 'Unknown',
        keywords: 'None'
    }
});