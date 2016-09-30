function Medico(data, currentMedico) {
    var self = this;
    self.Id = data.id;
    self.Nombre = data.nombre;
    self.Estrellas = data.estrellas;
    self.Votos = data.votos;
    self.ImagenUrl = data.imagenUrl;
    self.Tags = data.tags;
    self.showModal = function(vm){
        currentMedico(vm);
        $('#myModal').modal('show');
    };
}

function AppViewModel() {
    var self = this;

    self.filtros = ko.observableArray();
    self.resultados = ko.observableArray();

    self.currentMedico = ko.observable(null);

    var data = JSON.parse(resultado);
    self.resultados.removeAll();
    jQuery.each(data, function(index, item) {
        self.resultados.push(new Medico(item, self.currentMedico));
    });
}


$(document).ready(function() {
    ko.applyBindings(new AppViewModel());
    initMap();


    $(document).on('shown.bs.collapse','.collapse', function(){
        $(this).parent().find(".fa-plus").removeClass("fa-plus").addClass("fa-minus");
    });
    $(document).on('hidden.bs.collapse','.collapse', function(){
        $(this).parent().find(".fa-minus").removeClass("fa-minus").addClass("fa-plus");
    });
});



var map;
function createMap(pos){
    var crd = pos.coords;
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: (crd.latitude != null ? crd.latitude:-34.397), lng: (crd.longitude != null ? crd.longitude:150.644)},
        zoom: 15
    });
}

function error(err) {
    console.warn('ERROR(' + err.code + '): ' + err.message);
};

function initMap() {
    var options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };
    navigator.geolocation.getCurrentPosition(createMap, error, options);
}