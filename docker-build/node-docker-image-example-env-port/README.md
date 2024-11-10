Example how create a docker image

### docker build -t rdnazev/app-node:1.0 .

### docker login

docker push rdnazev/app-node:1.2

docker run -d -p 9090:6000 rdnazev/app-node:1.2
