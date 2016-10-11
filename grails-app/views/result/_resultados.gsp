<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Find a doctor</title>

    <asset:link rel="icon" href="favicon-hospital-o.ico" type="image/x-ico" />
</head>
<body>

<div class="row" data-bind="foreach: resultados">

    <div class="list-group" data-bind="click: showModal">
        <div href="#" class="list-group-item">
            <div class="row">
                <div class="col-md-4">
                    <a href="#" class="thumbnail">
                        <img data-bind="attr:{src: ImagenUrl}" alt="...">
                    </a>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <h4 class="list-group-item-heading" data-bind="text: Nombre"></h4>

                        <p class="list-group-item-text" style="height: 70px;">tags</p>
                    </div>
                </div>
            </div>
            <div class="row text-right">
                <div class="col-md-7 col-md-offset-3 star-rating" style="padding-right: 0px;">
                    <span class="fa" data-bind="css: {'fa': true, 'fa-star': (Estrellas >= 1), 'fa-star-o': (Estrellas < 1) }"></span>
                    <span class="fa" data-bind="css: {'fa': true, 'fa-star': (Estrellas >= 2), 'fa-star-o': (Estrellas < 2) }"></span>
                    <span class="fa" data-bind="css: {'fa': true, 'fa-star': (Estrellas >= 3), 'fa-star-o': (Estrellas < 3) }"></span>
                    <span class="fa" data-bind="css: {'fa': true, 'fa-star': (Estrellas >= 4), 'fa-star-o': (Estrellas < 4) }"></span>
                    <span class="fa" data-bind="css: {'fa': true, 'fa-star': (Estrellas >= 5), 'fa-star-o': (Estrellas < 5) }"></span>
                </div>
                <p style="margin-top: 3px; padding:0px 0px 0px 6px" class="col-md-2 text-left" data-bind="text: '('+Votos+')'"></p>
            </div>
        </div>
    </div>

</div>

</body>
</html>