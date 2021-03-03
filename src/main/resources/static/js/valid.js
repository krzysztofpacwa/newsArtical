// Validate Edit News
let editTitleError;
let editUrlError;
let editDescriptionError;
let editpublishedError;
function validateEditCar() {
    // title
    let titleEditValue = $('#titleEdit').val();
    if (titleEditValue.length === 0) {
        $('#titleEditMessage').show();
        editTitleError = true;
    } else {
        $('#titleEditMessage').hide();
        editTitleError = false;
    }
    // imageUrl
    let imageUrlEditValue = $('#imageUrlEdit').val();
    if (imageUrlEditValue.length === 0) {
        $('#imageUrlEditMessage').show();
        editUrlError = true;
    } else {
        $('#imageUrlEditMessage').hide();
        editUrlError = false;
    }
    // description
    let descriptionEditValue = $('#descriptionEdit').val();
    if (descriptionEditValue.length === 0) {
        $('#descriptionEditMessage').show();
        editDescriptionError = true;
    } else {
        $('#descriptionEditMessage').hide();
        editDescriptionError = false;
    }

    // published
    let bublishedEditValue = $('#publishedEdit').val();
    if (bublishedEditValue.length === 0) {
        $('#publishedEditMessage').show();
        editpublishedError = true;
    } else {
        $('#publishedEditMessage').hide();
        editpublishedError = false;
    }

    return !(editTitleError ||editDescriptionError || editUrlError || editpublishedError);
}

// Submit edit Car
$('#submitEdit').click(function () {
    return validateEditCar();
});

// toggleEditModal on click
$('#toggleEditModal').click(function () {
    $('#titleEditMessage').hide();
    $('#imageUrlEditMessage').hide();
    $('#descriptionEditMessage').hide();
    $('#publishedEditMessage').hide();
});