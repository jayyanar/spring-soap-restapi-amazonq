
✅ Step 1: Understand the SOAP Operation

You are helping me refactor a SOAP API to a RESTful API.

Here is the WSDL or SOAP operation I want to convert:
<My WSDL> - Please refer the WSDL Sample file name WSDL.md

1. Identify the operation name, input, output, and endpoint structure.
2. Summarize what this operation does in plain language.
3. Suggest what the RESTful equivalent might look like (e.g., HTTP method, URL path, request/response JSON).

Please explain your reasoning.

✅ Step 2: Generate REST API Design

Now that we’ve understood the SOAP operation, help me design the equivalent REST API.

1. Suggest the appropriate HTTP method (GET/POST/PUT/DELETE).
2. Define the REST endpoint path.
3. Define the request and response body in JSON (sample).
4. Suggest appropriate status codes and error responses.

Keep the design clean and RESTful (resource-oriented, stateless).

✅ Step 3: Refactor Service Layer Logic (Select Amazon Q Developer Agent /dev)

Help me refactor the following service logic from the existing SOAP service to be used in the REST API.

@src

1. Rewrite or adjust this logic to remove SOAP-specific dependencies (e.g., SOAP envelope handling, marshalling).
2. Make it suitable for a REST controller/service class.

Ensure compatibility with REST best practices and modern frameworks (e.g., Spring Boot for Java).

✅ Step 4: Create REST Controller or Route (Select Amazon Q Developer Agent /dev)
p
Now help me write the REST controller (or route handler) for the REST API equivalent of this SOAP operation.

1. Use Spring Boot style.
2. Include request mapping, request body parsing, response building, and exception handling.
3. Replace the SOAP related Code and Update to REST API Code only

This should call the refactored service logic.
 
✅ Step 5: Validate and Test  (Select Amazon Q Developer Agent /dev)

Now help me write a test (unit or integration) for the REST endpoint we just created.

1. Use JUnit depending on the tech stack.
2. Simulate a request with a sample JSON payload.
3. Validate the response and assert status codes and payloads.

Also suggest what kind of regression or compatibility tests I should run to validate parity with the old SOAP version.

✅ Step 6: Document the REST API (Optional)

Help me write an OpenAPI (Swagger) spec for this newly created REST API.

1. Include endpoint, method, request/response schema, and error codes.
2. Annotate with comments if possible for documentation tools.

This helps with future automation and documentation pipelines.


✅ Step 7: Update the README with Validation Steps  (Select Amazon Q Developer Agent /doc)
Help me update the README File

1. Include endpoint and Validation steps
2. Expected Results
