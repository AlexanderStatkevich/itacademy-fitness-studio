FROM swaggerapi/swagger-ui:latest
LABEL maintainer="it-academy"

ADD /product-service/spec/product-service.yml /usr/share/nginx/html/doc/product-service.yaml
ADD /user-service/spec/user-service.yml /usr/share/nginx/html/doc/user-service.yaml

ENV URLS="[{ url: 'doc/product-service.yaml', name: 'Product'},{ url: 'doc/user-service.yaml', name: 'User'},]"
ENV URLS_PRIMARY_NAME="User"