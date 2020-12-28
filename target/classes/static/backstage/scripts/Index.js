$(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})
$(".accordion-inner").click(function () {
    $(".active").html($(this).find(".left-body").text());
})

$(window).resize(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})
function xianshi1() {
    document .getElementById ("user").src="";
    document .getElementById ("user").src="Index2";
}
function xianshi2() {
    document .getElementById ("user").src="";
    document .getElementById ("user").src="index3";
}
function xianshi3(){
    document .getElementById ("user").src="";
    document.getElementById("user").src="index4";
}
function tishi(){
    alert("置顶成功！");
}