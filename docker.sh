echo "停止容器："
docker stop myspring
echo "删除容器："
docker rm myspring
echo "删除镜像："
docker rmi dockerspringboot
echo "打包："
mvn clean package  docker:build
echo "当前docker 镜像："
docker images | grep dockerspringboot
echo "启动容器----->"
docker run --name myspring -p 8001:8001 -d dockerspringboot
echo "启动服务成功！"