# MountainPeakAPI
Quick simple Spring-Boot API with a Dockerfile

## Prerequisites
- Maven
- Docker

Can compile Maven to generate a jar file (Skipping testing in case PostgreSQL isn't installed on the current host)
```mvn install -DskipTests```

Use Dockerfile to generate the docker image:
```docker build -t blog-api-docker.jar .```

Go to the docker-composer folder at `src/main/docker/`

Execute command:
```docker-compose up -d```

Documented API to help you test: 
Go to `http://localhost:8080/swagger-ui/index.html`

Enjoy :)
