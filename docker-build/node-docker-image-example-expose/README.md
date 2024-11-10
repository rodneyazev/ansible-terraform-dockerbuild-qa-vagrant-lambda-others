Example how create a docker image

### docker build -t rdnazev/app-node:1.1 .

### docker login

docker push rdnazev/app-node:1.1

docker run -d -p 8080:3000 rdnazev/app-node:1.1
