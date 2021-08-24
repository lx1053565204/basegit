mvn clean package  docker:build
echo "当前docker 镜像："
docker images
echo "停止镜像："
docker stop myspring
echo "删除 镜像："
docker rm myspring
echo "启动容器----->"
docker run --name myspring -p 8001:8001 -d dockerspringboot
echo "启动服务成功！"