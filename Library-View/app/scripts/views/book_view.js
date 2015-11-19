/**
 * Created by krido02 on 11/12/2015.
 */

var app = app || {};

app.BookView = Backbone.View.extend({

    tagName: 'div',
    className: 'bookContainer',
    template: _.template( $('#bookTemplate').html() ),

    render: function() {
        //  tmpl is a function that takes a JSON object and returns html.

        //  this.el is what we defined in tagName.  Use $el to get access to
        //  JQuery html() function.
        this.$el.html( this.template( this.model.toJSON() ) );

        return this;
    },

    events: {
        'click .delete': 'deleteBook'
    },

    deleteBook: function() {
        //  Delete the model.
        this.model.destroy({wait: true});


        //  Delete the view.
        this.remove();
    }

});