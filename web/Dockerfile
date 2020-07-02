# base image
FROM node:9.4

# set working directory
WORKDIR /usr/src/app

ARG div_bk_color=green
ENV REACT_APP_DIV_BK_COLOR=$div_bk_color
ENV CHOKIDAR_USEPOLLING=true
ENV DANGEROUSLY_DISABLE_HOST_CHECK=true

# install and cache app dependencies
COPY package*.json ./
ADD package.json /usr/src/app/package.json
RUN npm install

# Bundle app source
COPY . .

# Specify port
EXPOSE 3000

# start app
CMD ["npm", "start"]
