*** Project Description ***

The Blog Platform application is designed to manage posts, articles, and comments within a blog system. It utilizes Java Spring Boot with JPA for backend management, providing RESTful APIs for CRUD operations on posts and comments.


*** Features ***

- Posts and Articles: The application distinguishes between regular posts and articles. Posts serve as the foundation for all content, including articles which inherit post properties while adding specific attributes such as topics.

- Comments: Users can interact with posts and articles by leaving comments. Each comment is associated with a specific post.


*** Class Diagram ***

----------------------------------------
|                Post                  |
----------------------------------------
| id: Long                             |
| title: String                        |
| content: String                      |
|                                      |
----------------------------------------
                     ^
                     |
                     |
----------------------------------------
|              Article                 |
----------------------------------------
| id: Long                             |
| title: String                        |
| content: String                      |
| topic: String                        |
|                                      |
----------------------------------------
                     |1
                     |
                     |
                     |*
----------------------------------------
|              Comment                 |
----------------------------------------
| id: Long                             |
| content: String                      |
| post: Post                           |
----------------------------------------


*** Technologies Used ***
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok

*** Development Tools ***
- IntelliJ IDEA
- GitHub
- DBeaver
- Postman

*** Usage ***

Once the application is running you can make HTTP requests using Postman or similar application.

*** Endpoints ***

    Posts
    - GET /api/posts: Get all posts
    - GET /api/post/{id}: Get a post by ID
    - GET /api/post/title?title={title}: Get a post by title
    - GET /api/posts/content?keyword={keyword}: Get posts containing a keyword in content
    - POST /api/posts: Create a new post
    - PUT /api/posts/{id}: Update an existing post by ID
    - PATCH /api/posts/title/{id}: Update a post's title by ID
    - PATCH /api/posts/content/{id}: Update a post's content by ID
    - DELETE /api/posts/{id}: Delete a post by ID
    
    Comments
    - GET /api/comments: Get all comments
    - POST /api/comments: Create new comment
    - DELETE /api/comment/{id}: Delete comment by ID
    
    Articles
    - GET /api/articles: Get all articles
    - POST /api/articles: Create new article
    - DELETE /api/article/{id}: Delete article by ID
    
*** Future Work ***

I plan to enhance search capabilities by implementing additional methods like "getPostByCommentContaining". This will allow users to search for posts based on specific keywords within their associated comments improving the application search function. 

*** Resources ***

https://www.sitepoint.com/rest-api/
https://www.baeldung.com/spring-requestparam-vs-pathvariable
https://betterprogramming.pub/building-a-spring-boot-rest-api-a-php-developers-view-part-i-6add2e794646
https://dzone.com/articles/the-simple-guide-to-http-verbs-patch-put-and-post
https://www.w3schools.com/