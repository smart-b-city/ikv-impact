````
## Execute integration test

 * Start test network based on bclan and with ssm and ex02 chaincode installed
```
docker-compose -f docker-compose-it.yaml up -d
```

## Edit /etc/host

```
127.0.0.1	ca.bc-coop.bclan
127.0.0.1	peer0.bc-coop.bclan
127.0.0.1	orderer.bclan

```

Documentation
```
https://www.w3.org/TR/verifiable-claims-data-model/
https://schema.org/

https://github.com/google/schemaorg-java
https://json-schema.org/implementations.html#validator-java
```
