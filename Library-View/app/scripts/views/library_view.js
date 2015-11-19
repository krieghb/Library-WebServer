/**
 * Created by krido02 on 11/12/2015.
 */

var app = app || {};

app.LibraryView = Backbone.View.extend({

    el: '#books',

    initialize: function( initialBooks) {
        //this.collection = new app.Library( initialBooks );
        this.collection = new app.Library();
        this.collection.fetch( { reset: true } );
        this.render();

        this.listenTo( this.collection, 'add', this.renderBook );
        this.listenTo( this.collection, 'reset', this.render );
    },

    //  render library by rendering each book in its collection.
    render: function() {
        this.collection.each( function( item ) {
            this.renderBook( item );
        }, this );
    },

    //  render a book by creating a BookView and appending the element
    //  it renders to the library's element.
    renderBook: function( item ) {
        var bookView = new app.BookView({
            model: item
        });

        this.$el.append( bookView.render().el );
    },

    events: {
        'click #add': 'addBook'
    },

    addBook: function( newBook ) {

        newBook.preventDefault();

        var formData = {};

        $( '#addBook div' ).children( 'input' ).each( function( i, el ) {

            if ( $(el).val() != '' ) {
                console.log("HI Everybody!");
                if (el.id === 'keywords') {
                    console.log("In Keywords now!");
                    //formData[el.id] = [];
                    //_.each($(el).val().split(' '), function (keyword) {
                    //    formData[el.id].push({'keyword': keyword});
                    //});
                    formData[el.id] = "Keyword: " + $(el).val();
                }
                else if (el.id === 'releaseDate') {
                    console.log("In releaseDate now!");
                    formData[el.id] = $('#releaseDate').datepicker('getDate').getTime();
                }
                else {
                    console.log("Everywhere else now!");
                    formData[el.id] = $(el).val();
                }

            }

            //  Clearing input field value.
            $(el).val('');
        });
        //var url = this.collection.url;
        //this.collection.add( new app.Book( formData ) );
        //this.collection.url = this.collection.url + "/create";

        this.collection.create( formData  );

        //this.collection.url = url;

    }

});