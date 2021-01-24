angular.module('app', []).controller('productController', function ($scope, $http) {
    const contextPath = 'http://localhost:8185/watch/api/v1';

    $scope.fillTable = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title: $scope.filter ? $scope.filter.title : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
                p: pageIndex
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;

            let minPageIndex = pageIndex - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 2;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.submitCreateNewProduct = function () {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    };

    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.fillWithFilter = function () {
        $scope.fillTable();
    };

    $scope.limits = [3, 5, 7, 10];

    $scope.updateSelected = function() {
        switch($scope.selectedOption){
            case 3:
                $scope.limitPage = 3;
                break;
            case 5:
                $scope.limitPage = 5;
                break;
            case 7:
                $scope.limitPage = 7;
                break;
            case 10:
                $scope.limitPage = 10;
                break;
        }
        $scope.fillTable();
    }

    $scope.goToCart = function () {
        window.location.assign('cart.html');
    }

    $scope.fillTable();
});