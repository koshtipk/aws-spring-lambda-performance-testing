# aws-spring-lambda-performance-testing
After implementing the spring-based lambda function, performance is the most important to be taken care of for application stability point of view. This article will show what are the best practices and changes I followed to improve lambda function performance.

### Class diagram
The below class diagram depicts the relationship between interfaces and classes used for this solution. Below are all concrete classes that provide base functionality support and are used in actual lambda implementation.

### Architecture - before changes
Let's take a look into the current implementation of lambda.

![Before architectural changes](doc/before_changes.jpg?raw=true)

#### Best practices for performance optimization
A few best practices which I found interesting for lambda performance optimization are:
- Separate the Lambda handler from your core logic (Core logic can be a part of the layer).
- Take advantage of execution environment reuse to improve the performance of your function.
- Control the dependencies in your function's deployment package.
- Minimize your deployment package size to its runtime necessities.
- Reduce the time it takes Lambda to unpack deployment packages
- Minimize the complexity of your dependencies.

Based on the above best practices, below are the changes taken.

### Architecture - after changes

Additionally, we will add JAVA_TOOL_OPTIONS=-XX:+TieredCompilation -XX:TieredStopAtLevel=1 environment variable which has significantly improved lambda performance.

### Performance test

After posting the above changes, let's test both the APIs and compare their results. We will be using the below lambda configuration.

| Lambda Configuration | Lambda -1 (before changes) | Lambda-2 (after changes) |
| ------ | ------ | ------ |
| API version | v1 | v2 |
| Memory  | 512 MB | 512 MB |
| Ephemeral storage | 512 MB | 512 MB |
| Timeout | 0 min 15 sec | 0 min 15 sec |
| Environment variables |  | JAVA_TOOL_OPTIONS=-XX:+TieredCompilation -XX:TieredStopAtLevel=1 |

#### Result comparison

We run two APIs v1 and v2 parallelly for 10 and 20 requests respectively and below is the report for the same.



