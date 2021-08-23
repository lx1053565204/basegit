mvn clean package  docker:build
echo "当前docker 镜像："
docker images
echo "启动容器----->"
docker run -p 8001:8001 -d dockerspringboot
echo "启动服务成功！"