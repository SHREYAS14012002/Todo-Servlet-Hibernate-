# Use Nginx as the base image
FROM nginx:latest

# Copy the built artifacts from the Maven project into the Nginx web server directory
COPY /path/to/your/maven/project/target/*.war /usr/share/nginx/html/

# Expose port 80 (default Nginx port)
EXPOSE 80
