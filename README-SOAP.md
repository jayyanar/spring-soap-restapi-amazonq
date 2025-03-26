# Spring Boot SOAP Web Service for Stock Price Queries

This project implements a SOAP web service that provides stock price information using Spring Boot and Spring Web Services. It offers a simple, standards-compliant way to expose and consume stock price data through SOAP endpoints.

The service demonstrates the implementation of a SOAP-based web service using Spring Boot's web services capabilities. It includes a stock price endpoint that accepts company names and returns simulated stock prices. The project uses Spring WS Core for SOAP processing, JAXB for XML binding, and includes comprehensive XML schema validation through WSDL definitions.

## Repository Structure
```
.
├── src/main/java/com/example/demo/
│   ├── DemoApplication.java          # Spring Boot application entry point
│   ├── config/
│   │   └── WebServiceConfig.java     # SOAP web service configuration
│   ├── endpoint/
│   │   └── StockPriceEndpoint.java   # SOAP endpoint implementation
│   └── model/
│       ├── StockPriceRequest.java    # Request data model
│       └── StockPriceResponse.java   # Response data model
├── src/main/resources/
│   └── application.properties        # Application configuration
├── pom.xml                          # Maven project configuration
└── mvnw/mvnw.cmd                    # Maven wrapper scripts
```

## Usage Instructions
### Prerequisites
- Java 8 or later
- Maven 3.6+ (optional, project includes Maven wrapper)
- An IDE with SOAP web service support (optional)

### Installation

#### Using Maven Wrapper
```bash
# Clone the repository
git clone <repository-url>
cd <project-directory>

# Build the project
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

#### Using Maven
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

### Quick Start
1. Start the application using one of the installation methods above
2. The SOAP web service will be available at: `http://localhost:8080/ws`
3. The WSDL can be accessed at: `http://localhost:8080/ws/stock.wsdl`

### More Detailed Examples

#### Sample SOAP Request
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:stk="http://example.com/stock">
   <soapenv:Header/>
   <soapenv:Body>
      <stk:StockPriceRequest>
         <stk:company>EXAMPLE</stk:company>
      </stk:StockPriceRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

#### Sample SOAP Response
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:StockPriceResponse xmlns:ns2="http://example.com/stock">
         <ns2:company>EXAMPLE</ns2:company>
         <ns2:price>150.0</ns2:price>
      </ns2:StockPriceResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Troubleshooting

#### Common Issues
1. **Port Already in Use**
   - Error: `Port 8080 already in use`
   - Solution: Change the port in `application.properties`:
     ```properties
     server.port=8081
     ```

2. **WSDL Not Accessible**
   - Check if the application is running
   - Verify the URL: `http://localhost:8080/ws/stock.wsdl`
   - Enable debug logging in `application.properties`:
     ```properties
     logging.level.org.springframework.ws=DEBUG
     ```

## Data Flow
The service processes stock price requests through a simple request-response flow, transforming SOAP requests into Java objects and back.

```ascii
Client Request -> SOAP/HTTP -> MessageDispatcherServlet -> StockPriceEndpoint -> Response
     |                                  |                           |
     |                                  |                           |
     v                                  v                           v
XML/SOAP Request           Request Validation            Business Logic
```

Component interactions:
1. Client sends SOAP request to `/ws` endpoint
2. `MessageDispatcherServlet` receives and routes the request
3. Request payload is unmarshalled to `StockPriceRequest` object
4. `StockPriceEndpoint` processes the request
5. Response is marshalled back to SOAP XML
6. SOAP response is sent back to the client
7. XML Schema validation occurs during marshalling/unmarshalling