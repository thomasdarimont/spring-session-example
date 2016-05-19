Redis Setup von mit `make start` starten.
https://github.com/mp911de/redis-intro

Via redis-cli keyspace events aktivieren `config set notify-keyspace-events KEA`

Spring Boot App starten.
via curl requests senden an:

```
- Session 1
curl -i -b cookies -c cookies 'http://localhost:8080/greet?name=foo'
curl -i -b cookies -c cookies 'http://localhost:8080/greet?name=bar'

--Session 2
curl -i -b cookies1 -c cookies1 'http://localhost:8080/greet?name=foo'
curl -i -b cookies1 -c cookies1 'http://localhost:8080/greet?name=bar'
```





