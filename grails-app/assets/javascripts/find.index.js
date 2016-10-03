function Filtro(data, array) {
    var self = this;
    self.descripcion = data.descripcion;

    self.cargarHijos = function() {
        if(self.filtrosAsociados != null && self.filtrosAsociados.length > 0){
            array([]);
            ko.utils.arrayPushAll(array, self.filtrosAsociados);
        }else{
            $("#myForm").append('<input type="hidden" name="filter" value="'+ self.descripcion + '" />').submit();
        }
    };

    if(data.filtrosAsociados != null){
        self.filtrosAsociados = getFiltersArray(data.filtrosAsociados, array);
    }
    else{
        self.filtrosAsociados = null;
    }
}

function AppViewModel() {
    var self = this;

    var filtrosObj = JSON.parse(filterTree);

    self.filterTree = ko.observableArray();
    ko.utils.arrayPushAll(self.filterTree, getFiltersArray(filtrosObj, self.filterTree));
}

function getFiltersArray(objArray, array){
    return objArray.map(function(a) {
            return new Filtro(a, array);
        }
    );
}

$(document).ready(function() {
    ko.applyBindings(new AppViewModel());
});
