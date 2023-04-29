Traefik ako reverzná proxy
==========================

Ukážka [Traefik Proxy](https://traefik.io/traefik/) ako reverznej proxy pre REST API backend a javascriptový frontend.

Architektúra
=============

- `rest-api`: Spring Boot REST API Backend - servovaný cez embedded Tomcat na portoch 8080 a replika na 8081
- `frontend`: JavaScript Frontend: servovaný cez Node.js/Express
  * na porte 3000.
  * spúšťaný cez `npm start`
- `traefik`: reverse proxy na porte 80, resp. 443. Obsahuje statickú i dynamickú konfiguráciu.

Technikálie
===========

- očakáva sa, že `/etc/hosts` má deklaráciu pre hostname `megaserver`.

