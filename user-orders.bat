curl -v --header "Content-Type: application/json" --request POST --data "{\"customerName\": \"Aaron\", \"customerAge\":  30, \"customerAddress\":  \"UK\"}" http://localhost:8080/customers

curl -v --header "Content-Type: application/json" --request POST --data "{\"customerID\": 1,  \"orderDetail\": \"camera\", \"orderDate\": \"2020-11-03T20:18:18\", \"orderAmount\": 123.45}" http://localhost:8080/orders

curl -v --header "Content-Type: application/json" --request POST --data "{\"customerID\": 1,  \"orderDetail\": \"computer\", \"orderDate\": \"2020-11-01T20:28:18\", \"orderAmount\": 99.99}" http://localhost:8080/orders

curl -v --header "Content-Type: application/json"  http://localhost:8080/customers
