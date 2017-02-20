function Comentario(data) {
    var self = this;
    self.Nombre =data.paciente.username;
    self.Texto =data.texto;
    self.ImagenUrl = data.paciente.imagenUrl;
    self.Fecha = data.fecha;
}

function Turno(data) {
    var self = this;
    self.Id = data.id;
    self.FechaHora = data.fechaHora;
    self.Estado = data.estado.name;
}

function Medico(data, currentMedico, currentUsuario) {
    var self = this;
    self.Id = data.id;
    self.Nombre = data.username;
    self.Estrellas = data.estrellas;
    self.Votos = data.votos;
    self.ImagenUrl = data.imagenUrl;
    self.Comentarios = ko.observableArray();
    self.Turnos = ko.observableArray();

    self.MensajeNuevo = ko.observableArray();
    self.Fecha = ko.observableArray();
    self.Hora = ko.observableArray();

    self.Direccion = data.direccion;
    self.Ciudad = data.ciudad;
    self.Telefono = data.telefono;
    self.PaginaWeb = data.paginaWeb;
    self.Email = data.email;
    self.Geolocalizacion = data.geolocalizacion;

    self.HorasLaborales = data.horasLaborales;
    self.TurnosPorHora = data.turnosPorHora;

    self.showModal = function(vm){
        $.getJSON('listComment',{ doctorId: self.Id},function(data){
            self.Comentarios.removeAll();
            jQuery.each(data, function(index, item) {
                self.Comentarios.push(new Comentario(item));
            });
        });
        $.getJSON('listTurns',{ doctorId: self.Id},function(data){
            self.Turnos.removeAll();
            jQuery.each(data, function(index, item) {
                self.Turnos.push(new Turno(item));
            });
        });

        currentMedico(vm);
        $('#myModal').modal('show');

        var clock = $('.clockpicker').clockpicker({
            placement: 'top',
            align: 'left',
            autoclose: 'True',
            enabledhour: self.HorasLaborales,
            enabledmin: self.TurnosPorHora
        });


        $('#datepicker').datepicker({
            inline: true,
            sideBySide: true,
            startDate: "tomorrow",
            maxViewMode: 1,
            language: "es",
            autoclose: true,
            daysOfWeekDisabled: "0,6",
            daysOfWeekHighlighted: "1,2,3,4,5"
        }).on('hide', function() {
            clock.clockpicker('show');
        });

    };
    currentMedico(self);

    self.agregarComentario = function (){
        var nuevoTexto = self.MensajeNuevo();
        var nuevoComentario = new Comentario({texto: nuevoTexto,fecha: 'hora nueva', paciente:currentUsuario });
        self.Comentarios.push(nuevoComentario);
        self.MensajeNuevo('');
        $.getJSON('saveComment',{ newComment : nuevoTexto, doctorId : self.Id});
    };

    self.crearTurno = function (){
        if(self.Fecha() == '' && self.Hora() == ''){
            MostrarAlertaError('Campo obligatorio requerido');
        }else{
            BloquearPantalla('Procesando');
            $.getJSON('createTurn',{ datetime : self.Fecha() + " " + self.Hora(), doctorId : self.Id})
                .complete(function (data) {
                        if(data.responseText == 'true'){
                            var nuevoTurno = new Turno({paciente:currentUsuario, fechaHora: self.Fecha() + " " + self.Hora(), estado: { name :'Pendiente'} });
                            self.Turnos.push(nuevoTurno);
                        }else{
                            MostrarAlertaError(data.responseText);
                        }
                        $.unblockUI();
                    }
                );
        }
    };
}

function AppViewModel() {
    var self = this;


    self.filtros = ko.observableArray();
    self.resultados = ko.observableArray();
    self.currentUsuario = currentUsuario != '' ? JSON.parse(currentUsuario) : '';
    self.currentMedico = ko.observable(null);

    var data = JSON.parse(resultado);
    self.resultados.removeAll();
    jQuery.each(data, function(index, item) {
        self.resultados.push(new Medico(item, self.currentMedico,self.currentUsuario));
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
}

function initMap() {
    var options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };
    navigator.geolocation.getCurrentPosition(createMap, error, options);
}