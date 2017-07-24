

$("#send").on("click",function (e) {
    e.preventDefault();
    $.ajax({
        url:'/event/add',
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(addEvents()),
        success:function () {

            addEventPicture(e)
        }
    })
})

function addEvents() {
    return {
        name:$("#name").val(),
        title:$("#brief description").val(),
        text:$("#text").val(),
    category:$("#category").val(),
    startDate:$("#startDate").val(),
        dateOfCompletion:$("#dateOfCompletion").val(),
        location:$("#location").val()
    }
}

function addEventPicture(e) {
    e.preventDefault();
    $.ajax({
        url: '/event/add/picture',
        method: 'POST',
        contentType: 'application/json',
        data:JSON.stringify(addPicture()),
        success:function () {

        }
     })

}


function addPicture() {
    return{
    multipartFile:$("mediaFile").val()
}}