$(document).ready(function () {
    $('.table .editButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        console.log(href);
        $.get(href, function (article, status) {
            $('#idEdit').val(article.id);
            $('#titleEdit').val(article.title);
            $('#imageUrlEdit').val(article.urlToImage);
            $('#descriptionEdit').val(article.description);
            $('#publishedEdit').val(article.publishedAt);
        });

        $('#titleEditMessage').hide();
        $('#imageUrlEditMessage').hide();
        $('#descriptionEditMessage').hide();
        $('#publishedMessage').hide();

        $('#editModal').modal();
    });

});
