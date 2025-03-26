# Spring Boot Stock Price API - A RESTful service for retrieving real-time stock prices

# Thanks to Amazon Q Developer Agents !Ref @prompt.md for Step by Step Seqence of Prompt used for Refactoring SOAP to REST API

This Spring Boot application provides a simple and efficient REST API for retrieving stock prices. It offers a clean interface for querying current stock prices by company name, with built-in error handling and response formatting.

The service is built using Spring Boot 2.5.14 and Java 8, providing a robust foundation for handling HTTP requests and responses. It features a layered architecture with clear separation of concerns between controllers, services, and data models. The API includes comprehensive error handling for both client-side validation errors and unexpected server-side issues.

## Repository Structure
```
.
├── src/
│   ├── main/java/com/example/demo/           # Core application code
│   │   ├── controller/                       # REST API endpoints
│   │   │   └── StockPriceController.java     # Handles HTTP requests for stock prices
│   │   ├── model/                            # Data models
│   │   │   └── StockPriceResponse.java       # Stock price response structure
│   │   ├── service/                          # Business logic layer
│   │   │   └── StockPriceService.java        # Stock price retrieval service
│   │   └── DemoApplication.java              # Application entry point
│   └── resources/
│       └── application.properties            # Application configuration
├── pom.xml                                   # Maven project configuration
├── mvnw                                      # Maven wrapper script for Unix
└── mvnw.cmd                                  # Maven wrapper script for Windows
```

## Usage Instructions
### Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven 3.6+ (optional, wrapper included)
- Internet connection for downloading dependencies

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd <repository-directory>
```

2. Build the application:

**Using Maven Wrapper (recommended)**
```bash
# For Unix-based systems
./mvnw clean install

# For Windows
mvnw.cmd clean install
```

**Using local Maven installation**
```bash
mvn clean install
```

### Quick Start
1. Start the application:
```bash
./mvnw spring-boot:run
```

2. The service will be available at `http://localhost:8080`

3. Make a request to get stock price:
```bash
curl "http://localhost:8080/api/stocks/price?company=AAPL"
```

### More Detailed Examples

1. Get stock price for a specific company:
```bash
curl -X GET "http://localhost:8080/api/stocks/price?company=MSFT"
```
Expected response:
```json
{
    "company": "MSFT",
    "price": 123.45
}
```

2. Error handling example (invalid company):
```bash
curl -X GET "http://localhost:8080/api/stocks/price?company="
```
Expected response:
```
400 Bad Request
Invalid company name provided
```

### Troubleshooting

1. Application fails to start
- Check if port 8080 is already in use
```bash
# Unix/Linux
lsof -i :8080
# Windows
netstat -ano | findstr :8080
```
- Verify Java version:
```bash
java -version
```
- Check application logs in console output

2. Maven build fails
- Ensure JAVA_HOME is properly set
- Clear Maven cache:
```bash
rm -rf ~/.m2/repository
```
- Enable debug output:
```bash
./mvnw clean install -X
```

## Data Flow
The application follows a simple request-response flow for stock price retrieval.

```ascii
Client Request → StockPriceController → StockPriceService → StockPriceResponse → Client
     ↑                     ↓                    ↓                    ↑
     └─────────────────────────── Error Handler ──────────────────────
```

Component interactions:
1. Client sends HTTP GET request with company parameter
2. StockPriceController validates the input
3. StockPriceService processes the request and retrieves price data
4. Response is formatted into StockPriceResponse object
5. Controller returns HTTP response with JSON payload
6. Error handlers catch and process any exceptions
7. Client receives either successful response or error message
8. All interactions use JSON for data exchange