# WSO2 Integration

WSO2 Integration is the platform for building services and integrations using sequence diagram like visual representation.

# Introduction

WSO2 Integration is an ultra high performance, lightweight, configuration-driven message integration system. It aims to encapsulate messaging between source and target systems that are built with disparate technologies, protocols, and standards. While it includes messaging between two systems, message mediation can be controlled by configuring WSO2 Integration's mediation logic.

# Key Features

* Ultra high performance and low latency  HTTP/S messaging.

* Sequence diagram like visual modelling for system integration.

* Supports thousands of concurrent connections/clients.

* Header-based routing using WSO2 Integration engine (Ballerina).

* Defines REST services/APIs using swagger like annotations.

* Lightweight and stateless service orchestration.


# Getting Started

## Start with samples

1) Sample integrations can be found at [CARBON_HOME]/samples/integration-flows directory. Select the passthrough.ballerina file and copy that to [CARBON_HOME]/deployment/integration-flows directory. 

```sh
@Path("/stocks")
@Source(interface="default")
@Api(tags = {
    "stock_info",
    "stock_update"
}, description = "Rest api for get stocks details", produces = MediaType.APPLICATION_JSON)
package com.sample;

constant endpoint stockEP = new EndPoint("http://localhost:8080/stockquote/all");

@GET
@PUT
@POST
@Path("/getStocks")
resource passthrough(message m) {
    message response;
    response = invoke(endpointKey=stockEP, messageKey=m);
    reply response;
}
```

2) Goto [CARBON_HOME]/bin directory and execute carbon.sh (carbon.bat) script to startup the Integration runtime component

3) This sample requires a backend service which will be invoked from the integration service. You can start up a sample MSF4J backend service by going into [CARBON_HOME]/samples/Services/StockQuoteService directory and run the following command
```sh
java -jar stockquote-fatjar-*.jar
```

4) Now your integration service and the backend is started and you can invoke the service using the following curl command
```sh
curl -v http://localhost:9090/stocks/getStocks
```

5) You should get the following result from the service
```sh
{
  "stocks": [
    {
      "symbol": "GOOG",
      "name": "Alphabet Inc.",
      "last": 652.3,
      "low": 657.81,
      "high": 643.15
    },
    {
      "symbol": "IBM",
      "name": "International Business Machines",
      "last": 149.62,
      "low": 150.78,
      "high": 149.18
    },
    {
      "symbol": "AMZN",
      "name": "Amazon.com",
      "last": 548.9,
      "low": 553.2,
      "high": 543.1
    }
  ]
}
```

## Start with Tooling
WSO2 Integration product distribution consists of executable(script)s which starts up the integration runtime and the tool. 

1) Goto [CARBON_HOME]/bin directory and execute tool.sh (tool.bat) script to startup the Integration Tooling component

2) Build your integration using the sequence diagram based visual modelling tool

3) Goto [CARBON_HOME]/bin directory and execute carbon.sh (carbon.bat) script to startup the Integration runtime component

4) Deploy the service from the tool into the runtime

5) Invoke the service using REST/SOAP client



