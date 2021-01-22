angular.module('app').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8150/watch/cart';

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/api/v1/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.cart = response.data;
        });
    };

    $scope.removeOrder = function (productId) {
        $http({
            url: contextPath + '/api/v1/cart/remove/' + productId,
            method: 'GET'
        }).then(function (response) {
            $scope.fillTable();
        });
    };

    $scope.fillTable();
});