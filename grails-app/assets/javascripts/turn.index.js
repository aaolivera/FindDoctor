function Turno(data) {
    var self = this;
    self.Id = data.id;
    self.FechaHora = data.fechaHora;
    self.Estado = data.estado.name;
}

function AppViewModel() {
    var self = this;

    self.turnos = ko.observableArray();

    var data = JSON.parse(turnos);
    self.turnos.removeAll();
    jQuery.each(data, function(index, item) {
        self.resultados.push(new Turno(item));
    });
}


$(document).ready(function() {
   // ko.applyBindings(new AppViewModel());

});
