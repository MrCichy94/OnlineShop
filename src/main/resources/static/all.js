//i got ready crud js, but i dont use it

var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl', function ($scope, $http) {

    $scope.refreshCart = function (cartId) {
        $http.get('/onlineshop/rest/cart/' + $scope.cartId)
            .success(function (data) {
                $scope.cart = data;
            });
    };

    $scope.clearCart = function () {
        $http.delete('/onlineshop/rest/cart/' + $scope.cartId)
            .success($scope.refreshCart($scope.cartId));

    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/onlineshop/rest/cart/add/' + productId)
            .success(function (data) {
                $scope.refreshCart($http.get('/onslineshop/rest/cart/get/cartId'));
                alert("Produkt pomyślnie dodany do koszyka!");
            });
    };
    $scope.removeFromCart = function (productId) {
        $http.put('/onlineshop/rest/cart/remove/' + productId)
            .success(function (data) {
                $scope.refreshCart($http.get('/onslineshop/rest/cart/get/cartId'));
            });
    };
});