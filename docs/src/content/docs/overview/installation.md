---
title: Installation
description: How to install Truthchain.
---
:::caution
Truthchain is currently in development and is not yet ready for production use. This page only describes how Truthchain will be installed once it is ready for production use.
:::

Truthchain is written in Java and can be easily run using Docker. Follow the steps below to run Truthchain:

### Installing Docker 
Install Docker on your machine by following the instructions for your specific operating system: Docker Installation Guide (https://docs.docker.com/get-docker/)

### Cloning the Repository
Clone the Truthchain repository to your local machine:
``` bash
git clone https://github.com/Collabwriting/truthchain.git
```

### Building the Docker Image
1. Navigate to the Truthchain directory:
``` bash
cd truthchain
```

2. Build the Docker image:
``` bash
docker build -t truthchain .
```

### Running Truthchain
Run Truthchain using Docker:
``` bash
docker run -p 3000:3000 truthchain
```

Access the Truthchain web interface by navigating to `http://localhost:3000` in your web browser.