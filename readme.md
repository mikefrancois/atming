# ING ATM Application

This application provides 2 things :
 . WebApplication Service to list all cities if you're authenticated
 . API service to list and search city

## Getting Started

This application was tested on Tomcat 7

### Prerequisites

If you're using webapplication interface, you've to be authenticated with these credentials

```
user = user
password = user123
```

### WebApplication

You can access to the webapplication directly via http://{ip_server}:{port}/ingatm/ui

The first page is login and if you're authenticated, you'll be redirected on http://{ip_server}:{port}/ingatm/ui/user .
There you'll find 2 links :
    - List all cities via a basic angular application
    - Logout

### APIService

You can access to the webapplication directly via http://{ip_server}:{port}/ingatm/api

List all cities

**GET Method** : /cities

Search atm based on specific city

**GET method** : /cities/{city}


## Authors

* **Mike Francois** - *Assignement* -

## License

This project is licensed under the Mike Francois License -

