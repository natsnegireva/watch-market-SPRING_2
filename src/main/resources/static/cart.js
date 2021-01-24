angular.module('app1').controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8185/watch/api/v1';

    $scope.showCart = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET'
        }).then(function (response) {
            $scope.Cart = response.data;
        });
    };

    $scope.addToCart = function (productId) {
        $http.get(contextPath + '/cart/add/' + productId)
            .then(function (response) {
                $scope.showCart();
            });
    }

    $scope.clearCart = function () {
        $http.get(contextPath + '/cart/clear')
            .then(function (response) {
                $scope.showCart();
            });
    }
    $scope.goBack = function () {
        window.location.assign('index.html');
    }

    $scope.showCart();
});