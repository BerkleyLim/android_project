//      var mapWidth = 37.3599605;
//      var mapHeight = 127.1058814;
//
//console.log("js 빌드 성공")
//alert("js 빌드 성공")
////    // 지도에 표시할 위치의 위도와 경도 좌표를 파라미터로 넣어줍니다.
////    var location = new naver.maps.LatLng(mapWidth, mapHeight);
//    var mapOptions = {
//      center: new naver.maps.LatLng(mapWidth, mapHeight),
//      zoom: 17,
//      zoomControl: true,
//      zoomControlOptions: {
//        position: naver.maps.Position.TOP_RIGHT,
//      },
//    };
//    var map = new naver.maps.Map(document.getElementById("map"), mapOptions);
//     new naver.maps.Marker({
//       position: location,
//       map,
//     });
//
//    var pano = new naver.maps.Panorama(document.getElementById("pano"), {
//      position: new naver.maps.LatLng(mapWidth, mapHeight),
//    });
//
//    var marker = new naver.maps.Marker({
//      position: new naver.maps.LatLng(mapWidth, mapHeight),
//    });
//
//    naver.maps.Event.addListener(pano, "init", function () {
//      marker.setMap(pano);
//
//      const proj = pano.getProjection();
//      const lookAtPov = proj.fromCoordToPov(marker.getPosition());
//      if (lookAtPov) {
//        pano.setPov(lookAtPov);
//      }
//    });

    // 지도
    $.ajax({
        url: "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?" +
                "w=300&" +
                "h=300&" +
                "center=127.1054221,37.3591614&" +
                "level=16&" +
                "format=jpg", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
//        data: { name: "홍길동" },  // HTTP 요청과 함께 서버로 보낼 데이터
        type: "GET",   // HTTP 요청 메소드(GET, POST 등)
//        dataType: "jsonp", // 서버에서 보내줄 데이터의 타입
        dataType: "application/json", // 서버에서 보내줄 데이터의 타입
//        headers: {
//            "Content-Type": "utf-8",
////            "Content-Type" : "application/json",
//            "X-NCP-APIGW-API-KEY-ID": "i8mi8w050u",
//            "X-NCP-APIGW-API-KEY": "HA1yHMniVOBiEWSbOanoJWVhONdO0B4fyTEjehj6"
//        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader("X-NCP-APIGW-API-KEY-ID", "i8mi8w050u");
            xhr.setRequestHeader("X-NCP-APIGW-API-KEY", "HA1yHMniVOBiEWSbOanoJWVhONdO0B4fyTEjehj6");
        },
        success: function (res) {
            console.log(res)
        },
        error: function (e) {
            console.log(e)
        }
    })
//    // HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
//    .done(function(json) {
//        $("<h1>").text(json.title).appendTo("body");
//        $("<div class=\"content\">").html(json.html).appendTo("body");
//    })
//    // HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
//    .fail(function(xhr, status, errorThrown) {
//        $("#text").html("오류가 발생했다.<br>")
//        .append("오류명: " + errorThrown + "<br>")
//        .append("상태: " + status);
//    })
//    //
//    .always(function(xhr, status) {
//        $("#text").html("요청이 완료되었습니다!");
//    });