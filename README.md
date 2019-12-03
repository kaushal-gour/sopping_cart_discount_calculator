# sopping_cart_discount_calculator

#Endpoint-

Request url-
localhost:8080/discountService/api/v1/amount/{amount}

For Example-
localhost:8080/discountService/api/v1/amount/6000

Request Method- GET

Sample Response-

{
    "purchaseAmount": 6000,
    "billAmount": 5400,
    "discount": 10
}