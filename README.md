# cadena
Academic Modular Blockchain Initiative

# Instructions

For this first approach you have to simple build the project out side before create the docker imagen and run it, because there is a problem that we aren't solve yet whit the libraries

# Install require libraries

You must install json from the group org.json through this link:

https://jar-download.com/artifacts/org.json/json/20131018/source-code

# Docker Installation

In this step you have two possibilities with Dockerfile or whit docker-compose.yml.

## DockerFile

### docker create image

    $ docker build -t blockchain-image .

### docker run and see the console

    $ docker run -it --rm --name blockchain blockchain-image
