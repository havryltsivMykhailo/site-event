/**
 * Created by михайло on 14.07.2017.
 */
$("#newFriends").on("click",function () {
    $("#newUsers").empty();
    $.ajax({
        url:'/find/by/users',
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify( $("#name").val()),
        success:function (user) {
            var html="";
            alert(user);
            if (user!=""){
for (var i=0;i<user.length;i++){
    html+="<div id='frend' onclick=window.location.assign('/profile/'"+user[i].id+") ><div id='photo'><img width='80%' height='100%' src='"+user[i].avatar+"'></div><div id='user'> "+user[i].secondName+" "+user[i].name+" </div></div><div id='delete"+user[i].id+"'></div>";
    сheckingForFriendship(user[i].id)
}
            }
            $("#newUsers").append(html);
        }
    })
})


function сheckingForFriendship(id) {
    $("#delete"+id).empty();
    $.ajax({

        url:'/profile/checking/friend/'+id,
        method:'GET',
        contentType:'application/json',
        success:function (f) {
            if (f===5){}
            else if (f===1){
                $("#delete"+id).append("<a href='/friend/delete/"+id+"'>delete friends</a>")
            }else if (f===2){

                $("#delete"+id).append("<a href='/profile/following/cancel/"+id+"' >Cancel following</a>")
            }else if (f===3){
                $("#delete"+id).append("<a href='/profile/add/friend/"+id+"' >Add friend</a>")

            }else if (f===4){     $("#delete"+id).append("<a href='/profile/"+id+"/add/followers' >Follow</a>") }
        }
    })

}