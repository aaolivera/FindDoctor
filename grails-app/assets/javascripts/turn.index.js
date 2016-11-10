function Turno(data) {
    var self = this;
    self.Id = data.id;
    self.FechaHora = data.fechaHora;
    self.Estado = data.estado.name;
    self.Medico = data.medico.username
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
