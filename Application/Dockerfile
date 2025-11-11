FROM registry.access.redhat.com/ubi8/nodejs-16

# Create app directory
WORKDIR /tmp

USER root

# Copy package.json to the workdir
COPY src/package*.json ./

# Install npm dependencies
RUN npm install && npm audit fix --force

# Copy the application file to the working directory
COPY src .

# Create local env variable for the PORT
ENV PORT 8080

USER 1001

EXPOSE 8080
CMD [ "node", "app.js" ]