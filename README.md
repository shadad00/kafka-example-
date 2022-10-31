# kafka-example


## Para levantar los containers necesarios 
Se deben tener instalado docker y docker-compose. 
```
docker-compose -f docker-compose.yml up -d
```

## Para crear un topic es necesario conectarse al container de kafka
### 
```
sudo docker exec -it kafka /bin/sh
```
Ir a la carpeta donde estan los binarios:
```
cd /opt/kafka
```
Para crear un topic se corre el siguiente comando: 
```
./bin/kafka-topics.sh --create --zookeeper "zookeeper:2181" \
 --replication-factor 1 --partitions 1 --topic topic-name 
```
Si se quieren listar los topics creados en el cluster: 
```
./bin/kafka-topics.sh --list --zookeeper "zookeeper:2181" 
```


## Referencias
Codigo de consumer y producer extraido de:
https://www.youtube.com/watch?v=NpzwlWYLOdE&list=PLa6iDxjj_9qVGTh3jia-DAnlQj9N-VLGp&index=14

Codigo de stream basado en:
https://kafka.apache.org/33/documentation/streams/
