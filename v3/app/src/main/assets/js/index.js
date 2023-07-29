$(document).ready() {

}

$("#pictureCamera").on('click', () => {
    picture = Android.callCamera();
    console.log(picture);
})