function Turno(data) {
    var self = this;
    self.Id = data.id;
    self.FechaHora = data.fechaHora;
    self.Estado = ko.observable(data.estado.name);
    self.Paciente = data.paciente.username;
    self.Aceptar = function () {
        self.Estado('Aceptado');
        $.getJSON('acceptTurn',{ turnId: self.Id});
    };
    self.Rechazar = function () {
        self.Estado('Cancelado');
        $.getJSON('cancelTurn',{ turnId: self.Id});
    };
}

function AppViewModel() {
    var self = this;

    self.turnos = ko.observableArray();

    var data = JSON.parse(turnos);
    self.turnos.removeAll();
    jQuery.each(data, function(index, item) {
        self.turnos.push(new Turno(item));
    });
}


$(document).ready(function() {
    ko.applyBindings(new AppViewModel());

});
