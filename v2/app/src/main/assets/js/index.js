/*
const sampleData = {이름,관련 링크,생성 일시,태그
                    웹사이트 리뉴얼,링크를 입력하세요 →,2023년 7월 9일 오후 4:16,"UI/UX, 브랜드"
                    3D 아트,링크를 입력하세요 →,2023년 7월 9일 오후 4:16,"3D, Blender"
                    리브랜딩,링크를 입력하세요 →,2023년 7월 9일 오후 4:16,"마케팅, 브랜드"
                    포스터 디자인,링크를 입력하세요 →,2023년 7월 9일 오후 4:16,"그래픽 디자인, 브랜드"}

*/


function sendToNative() {
    const fileName = "../data.csv";
    alert(fileName);
    const nativeData = Android.webViewJSTest(fileName);

    const btnElement = document.getElementById("nativeBtn");

    btnElement.innerHTML = nativeData;


}
