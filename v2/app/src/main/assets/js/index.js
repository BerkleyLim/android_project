      var mapWidth = 37.3599605;
      var mapHeight = 127.1058814;

console.log("js 빌드 성공")
alert("js 빌드 성공")
//    // 지도에 표시할 위치의 위도와 경도 좌표를 파라미터로 넣어줍니다.
//    var location = new naver.maps.LatLng(mapWidth, mapHeight);
    var mapOptions = {
      center: new naver.maps.LatLng(mapWidth, mapHeight),
      zoom: 17,
      zoomControl: true,
      zoomControlOptions: {
        position: naver.maps.Position.TOP_RIGHT,
      },
    };
    var map = new naver.maps.Map(document.getElementById("map"), mapOptions);
     new naver.maps.Marker({
       position: location,
       map,
     });

    var pano = new naver.maps.Panorama(document.getElementById("pano"), {
      position: new naver.maps.LatLng(mapWidth, mapHeight),
    });

    var marker = new naver.maps.Marker({
      position: new naver.maps.LatLng(mapWidth, mapHeight),
    });

    naver.maps.Event.addListener(pano, "init", function () {
      marker.setMap(pano);

      const proj = pano.getProjection();
      const lookAtPov = proj.fromCoordToPov(marker.getPosition());
      if (lookAtPov) {
        pano.setPov(lookAtPov);
      }
    });