'use strict';

angular.module('myApp').controller('ControllerService', ['$scope', 'LocatorService', function($scope, LocatorService) {
    var self = this;
    self.atm={address:'',distance:'',type:'' };
    self.atms=[];

    fetchAllAtms();

    function fetchAllAtms(){
        LocatorService.fetchAllAtms()
            .then(
                function(d) {
                    self.atms = d.atms;
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                }
            );
    }

}]);