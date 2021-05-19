# GraphQL + Spring Boot Demo
* domain: book and author
* H2 database
* GraphQL library: com.graphql-java-kickstart:graphql-spring-boot-starter
* embedded GraphiQL tool => /graphiql
* embedded Altair tool => /altair
* embedded GraphQL Playground tool => /playground
* embedded Voyager tool => /voyager

## Getting started
* ```./gradlew bootRun```

## Query
* bookById
* findAllBooks

## Mutation
* createBook

## GraphQL Examples
```graphql
query allBooks {
  findAllBooks {
    id
    title
    pageCount
    author {
      firstName
      lastName
    }
  }
}

mutation createBooks {
  book1: createBook(title: "Lord Of The Rings", pageCount: 872, authorFirstName: "J.R.R.", authorLastName: "Tolkien") {
    id
    title
    author {
      lastName
      firstName
    }
  }
  book2: createBook(title: "Harry Potter and the Philosopher's Stone", pageCount: 223, authorFirstName: "Joanne", authorLastName: "Rowling") {
    id
    title
    author {
      lastName
      firstName
    }
  }
  book3: createBook(title: "Moby Dick", pageCount: 635, authorFirstName: "Herman", authorLastName: "Melville") {
    id
    title
    author {
      lastName
      firstName
    }
  }
  book4: createBook(title: "Interview with the vampire", pageCount: 371, authorFirstName: "Anne", authorLastName: "Rice") {
    id
    title
    author {
      lastName
      firstName
    }
  }
}
```

## cURL example
```shell
curl -X POST -H "Content-type: application/json" http://localhost:8080/graphql -d '{"query": "{ bookById(id:\"1\") {id title pageCount author { id firstName lastName } } }"}'
```

## Links
* https://graphql.org/code/#java-kotlin
* https://www.graphql-java.com/
* https://www.graphql-java-kickstart.com/tools/
* https://www.howtographql.com/graphql-java
* https://www.electronjs.org/apps/graphiql
* https://www.maxivanov.io/make-graphql-requests-with-curl/
* https://github.com/howtographql
* https://github.com/penckert/spring-boot-graphql-demo