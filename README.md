![Build Status](https://github.com/pat-lego/io.github.vm.patlego.website/workflows/Deploy%20Project/badge.svg)
[![Coverage Status](https://coveralls.io/repos/github/pat-lego/io.github.vm.patlego.website/badge.svg?branch=master)](https://coveralls.io/github/pat-lego/io.github.vm.patlego.website?branch=master)

# Karaf Based Website
Blog Engine for the patlego system

# How to build

In order to build the entire project perform the following command in the `website/` folder `mvn clean install`. This will build all modules of the application.

# How to build website

In order to build just the website make sure that `node & npm` are installed and navigate to the following folder `website/website.ui/src/main/resources/website.ui/` and run `npm install && npm run generate`, this will generate the static HTML for the site.

# How to test website

In order to build just the website make sure that `node & npm` are installed and navigate to the following folder `website/website.ui/src/main/resources/website.ui/` and run `npm install && npm run test:unit`, this will generate the static HTML for the site.

# Modules

## website.core

This is where all of the servlets are located, typically any business logic occurs here.

## website.dao

This is where all of the data access occurs, such as requesting, inserting and altering data from the DB. 

## website.ui

This is where the wepapp lives and is stored within the generated bundle.

# Contributors
- [Patrique Legault](https://github.com/patlego)
