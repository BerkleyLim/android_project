$(document).ready(() => {
//    alert("로딩 성공")
})

$("#cameraButton").on('click', () => {
//    alert("웹뷰 성공")
    Android.callCamera();
    alert("카메라 작업 끝");
    console.log(picture);
})