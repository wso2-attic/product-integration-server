#WSO2 Integration Server


Running Samples
---------------

Configuration can be deployed to server by dropping any sample configuration file in <CARBON_HOME>/samples/integration-flows/
to <CARBON_HOME>/deployment/integration-flows/ directory.

MSF4J SimpleStockQuote fat jar sample is used as the backend service for the integration flow samples. Follow the instruction of the
README.md of Stockquote service resides in <CARBON_HOME>/samples/Services/StockquoteService/ to start the backend service.


How to test the sample
----------------------

Use following cURL commands.

curl http://localhost:9090/stock/passthrough

You should get a successful response according the sample configurations if everything worked fine.
