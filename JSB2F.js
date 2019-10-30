
function showAllRecords() {
    let request = new XMLHttpRequest();
    request.open ("GET", "https://localhost:9001/showAllLists");
    request.onload = function() {
        renderData(JSON.parse(request.response));
        }
    }
function findbyfeaturedArtist() {
    let request = new XMLHttpRequest();
    request.open ("GET", "https://localhost:9001/findByFeaturedArtist/{a}");
    request.onload = function() {
        renderData(JSON.parse(request.response));
        }
    request.send();
        }
        function findbysubGenre() {
            let request = new XMLHttpRequest();
            request.open ("GET", "https://localhost:9001/findBySubGenre/{sg}");
            request.onload = function() {
                renderData(JSON.parse(request.response));
                }
            request.send();
                }
                function findbyplayListName() {
                    let request = new XMLHttpRequest();
                    request.open ("GET", "https://localhost:9001/findByPlayListName/{pn}");
                    request.onload = function() {
                        renderData(JSON.parse(request.response));
                        }
                    request.send();
                        }
                        function findbyUrl() {
                            let request = new XMLHttpRequest();
                            request.open ("GET", "https://localhost:9001/findByUrl/{u}");
                            request.onload = function() {
                                renderData(JSON.parse(request.response));
                                }
                            request.send();
                                }
                                function findbysubGenreandfeaturedArtist() {
                                    let request = new XMLHttpRequest();
                                    request.open ("GET", "https://localhost:9001/findBySubGenreandFeaturedArtist/{s}/{ar}");
                                    request.onload = function() {
                                        renderData(JSON.parse(request.response));
                                        }
                                    request.send();
                                        }
                                    