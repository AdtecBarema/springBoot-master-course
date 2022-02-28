- Feign: provides the ability to have a declarative REST client  for our application

- Install Spring cloud and OpenFeign:
    - Follow the instruction from spring-cloud:
    https://spring.io/projects/spring-cloud

    - Add the following dependency management to pom.xml

        <properties>
            <java.version>11</java.version>
            <spring.cloud-version>2021.0.0</spring.cloud-version>
        </properties>

        <dependencyManagement>
            <dependencies>
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-dependencies</artifactId>
                    <version>${spring.cloud-version}</version>
                    <type>pom</type>
                    <scope>import</scope>
                </dependency>
            </dependencies>
        </dependencyManagement>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
- Annotate the application with @EnableFeignClients

- Create test a Feign client
      - create an interface
      - annotate the interface with @FeignClient, and pass the remote url from where we want to make a rest call
      - create unimplemented methods the way we are creating in a regular API declaration
      - Test the Feign client

     Create Sample Feign client,JSONPlaceHolderClient:
                 @FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com/")
                 public interface JSONPlaceHolderClient {
                     @GetMapping("/posts")
                     List <Post> getPosts();
                     @GetMapping("/posts/{postId}")
                     Post getPost(@PathVariable("postId") Integer postId);
                 }

     Test sample Feign client, JSONPlaceHolderClient:
                 @Configuration
                 public class JSONPlaceHolderConfiguration {
                     @Bean("jsonplaceholder")
                     CommandLineRunner runner(JSONPlaceHolderClient jsonPlaceHolderClient){
                         return args -> {
                             System.out.println ( "https://jsonplaceholder.typicode.com/posts");
                             System.out.println ( jsonPlaceHolderClient.getPosts ().size ());
                             System.out.println ();
                             System.out.println ( "https://jsonplaceholder.typicode.com/posts");
                             System.out.println ( jsonPlaceHolderClient.getPost(1));
                         };}}


Important links:

   1. Feign Feature overview (map with current key features provided by feign):
        https://github.com/OpenFeign/feign

   2. Json Placeholder, fake API for test purpose
        https://jsonplaceholder.typicode.com/

   3. Install spring-cloud, such as OpenFeign:
          https://spring.io/projects/spring-cloud
