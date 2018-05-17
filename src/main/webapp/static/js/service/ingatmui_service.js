'use strict';

angular.module('myApp').factory('LocatorService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8090/ingatm/api/cities';

    var factory = {
        fetchAllAtms: fetchAllAtms
      };

    return factory;

    function fetchAllAtms() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Atms');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }



}]);